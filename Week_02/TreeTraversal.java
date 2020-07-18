package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-17-02-2:27 AM
 */
public class TreeTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public List<Integer> inorderTraversal(TreeNode treeNode){
        List<Integer> result = new ArrayList<>();
        _doInOrder(treeNode,result);
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        _doPreOrder(treeNode,result);
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        _doPostOrder(treeNode,result);
        return result;
    }



    private void _doInOrder(TreeNode treeNode, List<Integer> result) {
        if(treeNode == null){
            return;
        }
        _doInOrder(treeNode.left,result);
        result.add(treeNode.val);
        _doInOrder(treeNode.right,result);
    }

    private void _doPreOrder(TreeNode treeNode,List<Integer> result) {
        if(treeNode == null){
            return;
        }
        result.add(treeNode.val);
        _doPreOrder(treeNode.left,result);
        _doPreOrder(treeNode.right,result);
    }

    private void _doPostOrder(TreeNode treeNode,List<Integer> result) {
        if(treeNode == null) {
            return;
        }
        _doPostOrder(treeNode.left,result);
        _doPostOrder(treeNode.right,result);
        result.add(treeNode.val);
    }





    public static void main(String[] args) {
        TreeNode treeNode = _buildTreeNode();
        TreeTraversal treeTraversal = new TreeTraversal();

        System.out.println(treeTraversal.inorderTraversal(treeNode).stream().map(x -> x.toString()).collect(Collectors.joining(",")));
        System.out.println(treeTraversal.preorderTraversal(treeNode).stream().map(x -> x.toString()).collect(Collectors.joining(",")));
        System.out.println(treeTraversal.postorderTraversal(treeNode).stream().map(x -> x.toString()).collect(Collectors.joining(",")));
    }



    private static TreeNode _buildTreeNode() {

        TreeNode root = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        root.right = treeNode2;
        treeNode2.left = treeNode3;
        return root;

    }




}
