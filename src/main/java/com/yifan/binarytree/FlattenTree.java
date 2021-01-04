package com.yifan.binarytree;

/**
 * <a>https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/</a>
 */
public class FlattenTree {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;

        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
