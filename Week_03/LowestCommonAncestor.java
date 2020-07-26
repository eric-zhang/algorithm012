package com.leetcode.week03;

/**
 * 类描述
 *
 * @author zhangjianfu
 * @create 2020-07-26-23-11:20 PM
 */
public class LowestCommonAncestor {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // terminator
        if(root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        // process curr logic

        // drill down
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) {
            return  right;
        }
        if(right == null){
            return  left;
        }
        return root;
        // reverse curr states
    }

    public static void main(String[] args) {
        TreeNode tree = _buildSourceTree();
        TreeNode root1 = lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(1));
        System.out.println(root1.val);
        TreeNode root2 = lowestCommonAncestor(tree, new TreeNode(5), new TreeNode(4));
        System.out.println(root2.val);
    }

    private static TreeNode _buildSourceTree() {
        // [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        return root;

    }


}
