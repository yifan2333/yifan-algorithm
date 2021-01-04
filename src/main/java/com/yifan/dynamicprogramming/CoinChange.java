package com.yifan.dynamicprogramming;

/**
 * <a>https://leetcode-cn.com/problems/coin-change/</a>
 * 动态规划问题
 * 初始数组 dp，长度为amount + 1,默认值为 amount + 1
 * dp[0] = 0;
 * 状态 硬币数量无线，面额也是题目给定的，只有金额会不断向base case靠近，唯一的状态就是目标金额 amount
 * dp[i] = min(dp[i], dp[i - coin])
 */
public class CoinChange {

    /**
     * Coin change int.
     *
     * @param coins  the coins
     * @param amount the amount
     * @return the int
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        return coinChange(coins, amount, dp);
    }

    /**
     * Coin change int.
     *
     * @param coins   the coins
     * @param amount  the amount
     * @param dp the dp
     * @return the int
     */
    public int coinChange(int[] coins, int amount, int [] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[] {1, 2, 5};
        System.out.println(coinChange.coinChange(coins, 11));
    }
}
