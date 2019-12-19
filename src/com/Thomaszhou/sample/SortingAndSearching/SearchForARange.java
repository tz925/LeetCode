package com.Thomaszhou.sample.SortingAndSearching;
/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int leftIndex = boundaryBS(nums, target, true);

        if (leftIndex >= nums.length || nums[leftIndex] != target) return result;

        result[0] = leftIndex;
        result[1] = boundaryBS(nums, target, false)-1;

        return result;
    }

    private int boundaryBS(int[] nums, int target, boolean left){
        int low = 0, high = nums.length;

        while(low < high){
            int mid = (low+high) / 2;

            if (nums[mid] > target || (left && target == nums[mid])) high = mid;
            else low = mid+1;
        }

        return low;
    }
}
