package com.leetcode.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 *
 * @author zhangjianfu
 * @create 2020-07-19-00-12:31 AM
 */
public class LevelOrder {


    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size ; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {

    }


    /**
     * 第二遍刷题：默写，一边默写一边说，强化理解和记忆
     * 广度优先搜索
     * 在做树的搜索的时候，可以借助队列，栈等线性的一维高级数据结构进行辅助
     * 使用队列放节点，每次根据queue.size获取到的就是当前层级的节点数，poll该层级的所有节点
     * 将值加入到当前层级的列表值中，同时将该层级中的所有子节点继续加到队列中，作为下个层级的节点
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder2(Node root) {
        if(root == null)  {
          return new ArrayList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i < size ; i ++ ){
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }


















}
