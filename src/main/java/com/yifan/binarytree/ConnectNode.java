package com.yifan.binarytree;

/**
 * <a>https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/</a>
 */
public class ConnectNode {

    /**
     * Connect node.
     *
     * @param root the root
     * @return the node
     */
    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);

        return root;
    }

    /**
     * Connect two node.
     *
     * @param treeNode1 the node 1
     * @param treeNode2 the node 2
     */
    public void connectTwoNode(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            return;
        }

        treeNode1.next = treeNode2;

        connectTwoNode(treeNode1.left, treeNode1.right);
        connectTwoNode(treeNode2.left, treeNode2.right);

        connectTwoNode(treeNode1.right, treeNode2.left);
    }

}
