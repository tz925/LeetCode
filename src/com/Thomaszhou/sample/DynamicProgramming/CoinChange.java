package com.Thomaszhou.sample.DynamicProgramming;

import java.util.Arrays;

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
//    public int coinChange(int[] coins, int amount){
//        if (amount < 1) return 0;
//
//        return coinChange(coins, amount, new int[amount]);
//    }
//// top down DP
//    public int coinChange(int[] coins, int remain, int[] count){
//        if (remain < 0) return -1;
//        if (remain == 0) return 0;
//        if (count[remain - 1] != 0) return count[remain - 1];
//
//        int min = Integer.MAX_VALUE;
//
//        for (int coin : coins) {
//            int res = coinChange(coins, remain - coin, count);
//            if (res >= 0 && res < min)
//                min = 1 + res;
//        }
//        count[remain - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
//        return count[remain - 1];
//    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
