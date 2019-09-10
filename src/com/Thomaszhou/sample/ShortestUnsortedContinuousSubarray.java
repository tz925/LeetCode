package com.Thomaszhou.sample;
/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedContinuousSubarray {
    /*
    double forloop for each i check if there is a j in wrong place.
    store the left most and right most i and j.
    time(n^2) space(1)
    */
//    public int findUnsortedSubarray(int[] nums) {
//        int l = nums.length, r = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] < nums[i]) {
//                    r = Math.max(r, j);
//                    l = Math.min(l, i);
//                }
//            }
//        }
//        return r - l < 0 ? 0 : r - l + 1;
//    }

    // or have a sorted copy of nums, the leftmost and rightmost mismatch index can determine result.
    // time(nlogn) from sorting . space(n) for copy;

    // use stack to remember last seen index with correct order on two side. time(n) space(n)

    /* use four for loops to find
    1. the min of unsorted subarray (start after we find first falling point)
    2. the max of unsorted subarray (backward start after we find first raising point)
    3. find the first index with value greater than min, thus the left boundary
    4. find the backward first index with value smaller than max thus the right boundary.
    time(n) space(1)
     */
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

}
