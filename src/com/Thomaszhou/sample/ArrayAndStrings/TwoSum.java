package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //brute force n(n/2) = n^2 time;
        /*
        for(int i=0; i< nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j]==target) return new int[]{i,j};
            }

        }
        return new int[]{0,0};
        */

        //HashTable space for time Time(n) Space(n)
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if(hashMap.containsKey(complement)){
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

}