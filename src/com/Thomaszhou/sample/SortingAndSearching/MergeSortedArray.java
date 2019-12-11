package com.Thomaszhou.sample.SortingAndSearching;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    // faster than 100% on leetcode time(m+n) space(1) no extra space.
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m-1; int tail2 = n-1; int lastindex = m+n-1;
        while(tail1 >=0 && tail2 >= 0){
            nums1[lastindex--] = nums1[tail1]>nums2[tail2]? nums1[tail1--] : nums2[tail2--];
        }
        while(tail2 >= 0){
            nums1[lastindex--] = nums2[tail2--];
        }
    }
}
