package com.yifan.binarytree;

/**
 * 构建最大二叉树
 * <a>https://leetcode-cn.com/problems/maximum-binary-tree/submissions/</a>
 */
public class ConstructMaximumBinaryTree {

    /**
     * Construct maximum binary tree tree node.
     *
     * @param nums the nums
     * @return the tree node
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    /**
     * Construct maximum binary tree tree node.
     *
     * @param nums the nums
     * @param lo   the lo
     * @param hi   the hi
     * @return the tree node
     */
    public TreeNode constructMaximumBinaryTree(int[] nums, int lo, int hi) {

        if (lo > hi) {
            return null;
        }

        int index = -1;
        int maxVal = Integer.MIN_VALUE;

        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaximumBinaryTree(nums, lo, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, hi);

        return root;
    }
}
