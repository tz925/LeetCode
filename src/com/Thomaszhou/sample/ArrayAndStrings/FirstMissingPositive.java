package com.Thomaszhou.sample.ArrayAndStrings;
/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if (nums[i] == i+1 || nums[i] > nums.length || nums[i] <= 0) {
                i++;
            }else if (nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
            else i++;
        }
        int j = 0;
        for (j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) return j+1;
        }
        return j+1;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
