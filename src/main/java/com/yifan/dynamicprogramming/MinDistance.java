package com.yifan.dynamicprogramming;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 *     插入一个字符
 *     删除一个字符
 *     替换一个字符
 * <a>https://leetcode-cn.com/problems/edit-distance/submissions/</a>
 * <a>https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/1.2-zi-xu-lie-lei-xing-wen-ti/bian-ji-ju-li</a>
 */
public class MinDistance {

    /**
     * Min distance int.
     *
     * @param word1 the word 1
     * @param word2 the word 2
     * @return the int
     */
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1,
                            dp[i - 1][j - 1] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }
        return dp[n][m];
    }
    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
