package com.yifan.dynamicprogramming;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <a>https://leetcode-cn.com/problems/longest-increasing-subsequence/</a>
 * <a>
 *     https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E8%AE%BE%E8%AE%A1%EF%BC%9A%E6%9C%80%E9%95%BF%E9%80%92%E5%A2%9E%E5%AD%90%E5%BA%8F%E5%88%97.md
 * </a>
 * The type Longest increasing subsequence.
 */
public class LongestIncreasingSubsequence {

    /**
     * Length of lis int.
     *
     * @param nums the nums
     * @return the int
     */
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            result = Math.max(result, i);
        }

        return result;
    }
}
