package com.Thomaszhou.sample;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        //brute force Time O(2^n) size of recursion tree is 2^n. Space O(n^2) a potenial length n array for each starting element.
//        return lengthofLIS(nums, Integer.MIN_VALUE, 0);

        // brute force with memo matrix to store seen result
//        int memo[][] = new int[nums.length + 1][nums.length];
//        for (int[] l : memo) {
//            Arrays.fill(l, -1);
//        }
//        return lengthofLIS(nums, -1, 0, memo);

        // DP time O(n^2) space O(n) 8ms 64% 36.9mb 40%
//        if (nums.length == 0) return 0;
//
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        int ans = 1;
//        for (int i = 0; i < nums.length; i++) {
//            int maxPrevVal = 0;
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) maxPrevVal = Math.max(dp[j], maxPrevVal);
//            }
//            dp[i] = maxPrevVal + 1;
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;

        // DP with Binary search O(nLogn) 12ms 30.56% space (n) 36.8MB 57%
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 0; i < nums.length; i++) {
            int maxPrevVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) maxPrevVal = Math.max(dp[j], maxPrevVal);
            }
            dp[i] = maxPrevVal + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public int lengthofLIS(int[] nums, int prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthofLIS(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    // brute force with memo matrix to store seen result
    public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
        if (curpos == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][curpos] >= 0) {
            return memo[previndex + 1][curpos];
        }
        int taken = 0;
        if (previndex < 0 || nums[curpos] > nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }
}
