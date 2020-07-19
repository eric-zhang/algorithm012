package com.leetcode.week02;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 *
 * @author zhangjianfu
 * @create 2020-07-19-01-1:31 AM
 */
public class PreOrder {

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


    public List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        _helper(root,res);
        return res;
    }

    private void _helper(Node node, List<Integer> res) {
        if(node == null) {
            return;
        }
        res.add(node.val);
        for(Node ne:node.children) {
            _helper(ne,res);
        }
    }


}
