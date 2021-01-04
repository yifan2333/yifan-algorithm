package com.yifan.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a>https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/</a>
 */
public class MinDepth {

    /**
     * Min depth int.
     *
     * @param root the root
     * @return the int
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur == null || (cur.left == null && cur.right == null)) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                   q.offer(cur.right);
                }
            }

            depth ++;
        }
        return depth;
    }

    private static class TreeNode{
        private int val;

        private TreeNode left;

        private TreeNode right;

        /**
         * Instantiates a new Tree node.
         */
        public TreeNode() {
        }

        /**
         * Instantiates a new Tree node.
         *
         * @param val   the val
         * @param left  the left
         * @param right the right
         */
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
