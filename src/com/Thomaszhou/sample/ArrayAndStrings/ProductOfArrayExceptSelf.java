package com.Thomaszhou.sample.ArrayAndStrings;
/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {
    // we can simply calculate the product of all numbers, then for each num in nums, we do product/num. but this is not
    // allowed by question.

    //if we for each num in nums, numtiply everything else, we are at time(n^2) not good enough


    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        int right = 1;
        for (int i = nums.length-1; i >=0 ; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }

        return answer;
    }
}
