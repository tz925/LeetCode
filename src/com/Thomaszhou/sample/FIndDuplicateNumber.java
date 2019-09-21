package com.Thomaszhou.sample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.

 */
public class FIndDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // sorting and for loop through, takes nlogn + n time, O(nlogn)

        // use Set or Map, time(n) space(n)

        // Smart Solution see nums like a linkedlist, then it is LinkedListCycleII.

        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        //now slow and fast meet.
        int p = nums[0];
        while(p != slow){
            p = nums[p];
            slow = nums[slow];
        }
        return p;
    }
}
