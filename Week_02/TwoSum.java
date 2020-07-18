package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-17-01-1:27 AM
 */
public class TwoSum {

    public static int[] towSumByTwoMap(int[] nums,int target) {

        if(nums.length < 2){
            return null;
        }

        Map<Integer,Integer> numsOfMaps = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            numsOfMaps.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(numsOfMaps.containsKey(temp) && numsOfMaps.get(temp).intValue() != i) {
                return new int[] {i,numsOfMaps.get(temp)};
            }
        }
        return null;
    }

    public static int[] towSumByOneMap(int[] nums,int target) {
        if(nums.length < 2){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i,map.get(temp)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static int[] towSumByViolence(int[] nums,int target) {
        if(nums.length < 2){
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = target - nums[i];
            for (int j = 1; j < nums.length; j++) {
                if(temp == nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,5,7,6};
        int target = 7;
        System.out.println(Arrays.toString(towSumByTwoMap(nums,target)));
        System.out.println(Arrays.toString(towSumByOneMap(nums,target)));
        System.out.println(Arrays.toString(towSumByViolence(nums,target)));
    }


}
