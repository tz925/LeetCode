package com.Thomaszhou.sample.ArrayAndStrings;
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaxProductSubarry {
    // prefix suffix solution
    public int maxProduct1(int[] nums) {
        int res = nums[0];
        int pre = 0, suf = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pre = (pre == 0 ? 1 : pre) * nums[i];
            suf = (suf == 0 ? 1 : suf) * nums[n-1-i];
            res = Math.max(res, Math.max(pre, suf));
        }

        return res;
    }

    // max min solution
    public int maxProduct2(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempmax = max;
            max = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(min * nums[i], Math.min(tempmax * nums[i], nums[i]));
            res = Math.max(max, res);
        }

        return res;
    }
}
