package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7]
Explanation:

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note:
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 */
public class SlidingWindowMaximum {
    /*
    brute force for each subsarray calculate max, which will be O(n*k)
     */

    /*
    accepted solution, with Deque/LinkedList we keep a list of index, at each step i we remove ones that are not in the
    slide window anymore (list.removeFirst, and ones that are in the back and smaller than nums[i] because they will not be useful (if they were equal or
    larger than nums[i] they will be kept as max or if max expires they will be candidate for max), then we add i to
    the end of list.
    get and remove first and last should cost O(1) with linkedList that keep pointers.
     */
    private LinkedList<Integer> deq = new LinkedList<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        if (N * k == 0) return new int[0];
        if (k == 1) return nums;

        //build init deq and max
        int max_index  = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(nums, i, k);
            deq.addLast(i);
            if (nums[max_index] < nums[i]) max_index = i;
        }
        int[] result = new int[N - k + 1];
        result[0] = nums[max_index];
        int j = 1;

        for (int i = k; i < N; i++) {
            cleanDeque(nums, i, k);
            deq.addLast(i);
            result[j++] = nums[deq.getFirst()];
        }

        return result;

    }

    private void cleanDeque(int[] nums, int i, int k){
        while(!deq.isEmpty() && deq.getFirst() == i - k){
            deq.removeFirst();
        }
        while(!deq.isEmpty() && nums[deq.getLast()] < nums[i] ){
            deq.removeLast();
        }
    }

}
