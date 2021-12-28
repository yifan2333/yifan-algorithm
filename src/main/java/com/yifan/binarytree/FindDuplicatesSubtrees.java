package com.yifan.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 查找二叉树相同的子树
 * <a>https://leetcode-cn.com/problems/find-duplicate-subtrees</a>
 *
 * @author wuyifan
 * @since 2021年12月27日 14:50
 */
public class FindDuplicatesSubtrees {

    private final Map<String, Integer> memo = new HashMap<>();
    private final List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicatesSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);

        String resStr = left + "," + right + "," + root.val;
        Integer count = memo.getOrDefault(resStr, 0);
        if (count == 1) {
            res.add(root);
        }
        memo.put(resStr, count + 1);
        return resStr;
    }
}
