package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 前K个高频元素
 *
 * @author zhangjianfu
 * @create 2020-07-18-14-2:41 PM
 */
public class TopKFrequent {

    public static class ElementNode {
        private Integer num;
        private int counts;

        public void setNum(Integer num){
            this.num = num;
            this.counts++;
        }

        public Integer getNum(){
            return num;
        }
        public Integer getCounts(){
            return this.counts;
        }

    }

    /**
     * 使用map进行对频次进行统计，最后将map的value进行排序
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequentForNodeSort(int[] nums, int k) {
        Integer length = nums.length;
        Map<Integer,ElementNode> map = new HashMap();
        for(int i = 0 ;i  < length;i ++ ){
            Integer num = nums[i];
            ElementNode node =  map.get(num);
            if(node == null) {
                node = _buildNode(num);
                map.put(num,node);
            }else {
                node.setNum(num);
            }
        }
        Set<Map.Entry<Integer, ElementNode>> entries = map.entrySet();
        List<ElementNode> collect = entries.stream()
                .map(x -> x.getValue())
                .sorted(Comparator.comparing(ElementNode::getCounts).reversed())
                .collect(Collectors.toList());
        int[] result = new int[k];
        for(int i = 0 ;i < k ;i ++){
            result[i] = collect.get(i).getNum();
        }

        return result;
    }

    private static  ElementNode _buildNode(Integer num) {
        ElementNode node = new ElementNode();
        node.setNum(num);
        return node;
    }


    /**
     * 使用小根堆进行频率统计的排序辅助
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topFrequentForHeap(int[] nums,int k) {
        Integer length = nums.length;
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0 ;i  < length;i ++ ){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        // 使用最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2) -> map.get(n1) - map.get(n2));
        for (int i = 0;i < nums.length;i++) {
            queue.add(nums[i]);
            if(queue.size() > k){
                queue.poll();
            }
        }

        List<Integer> collect = queue.stream().collect(Collectors.toList());
        return collect;

    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequentForNodeSort(nums,k)));
        System.out.println(Arrays.toString(topKFrequentForNodeSort(new int[]{1,2},1)));
        System.out.println(Arrays.toString(topKFrequentForNodeSort(new int[]{1,2,1,2,3,3,4},3)));
        System.out.println(Arrays.toString(topFrequentForHeap(new int[]{1,2,1,2,3,3,4},3).toArray()));
    }
}
