package com.yifan.binarytree;

/**
 * The type Max sum bst.
 *
 * @author wuyifan
 * @date 2021年01月19日 11:20
 */
public class MaxSumBST {

    private int maxSum = 0;

    /**
     * Msx sum bst int.
     *
     * @param root the root
     * @return the int
     * @author wuyifan
     * @date 2021年01月19日 11:20
     */
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /**
     * res[0]记录以root为根的二叉树是否是 BST，若为 1 则说明是 BST，若为 0 则说明不是 BST；
     * res[1]记录以root为根的二叉树所有节点中的最小值；
     * res[2]记录以root为根的二叉树所有节点中的最大值；
     * res[3]记录以root为根的二叉树所有节点值之和。
     *
     * @param root the root
     * @return the int [ ]
     * @author wuyifan
     * @date 2021年01月19日 11:21
     */
    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int val = root.val;
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && val > left[2] && val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], val);
            res[2] = Math.max(right[2], val);
            res[3] = left[3] + right[3] + val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        TreeNode treeNode6 = new TreeNode(2);
        TreeNode treeNode7 = new TreeNode(5);
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        TreeNode treeNode8 = new TreeNode(4);
        TreeNode treeNode9 = new TreeNode(6);

        treeNode7.left = treeNode8;
        treeNode7.right = treeNode9;

        MaxSumBST maxSumBST = new MaxSumBST();
        System.out.println(maxSumBST.maxSumBST(treeNode1));
    }
}
