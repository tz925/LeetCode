package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class FourSum {
    // O(n ^ (k-1)) time O(1) space.
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target){
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k == 2){
            int l = start, r = len - 1;
            while(l < r){
                int sum = nums[l]+nums[r];
                if(sum == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    result.add(temp);
                    //avoid duplicate
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;r--;
                }
                else if(sum < target) l++;
                else if(sum > target) r--;
            }
            return result;
        }
        // k > 2 sum
        else{
            for(int i = start; i < len - (k - 1); i++){
                if(i>start && nums[i] == nums[i-1]) continue;
                List<List<Integer>> temp = kSum(nums, i+1, k-1, target-nums[i]);
                for(List<Integer> t: temp){
                    t.add(nums[i]);
                }
                result.addAll(temp);
            }
            return result;
        }
    }
}
