package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new ArrayList<>(), nums,0);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, List<Integer> templist, int[] nums, int start){
        ans.add(new ArrayList<>(templist));

        for (int i = start; i < nums.length; i++) {
            templist.add(nums[i]);
            backTracking(ans, templist, nums, i+1);
            templist.remove(templist.size()-1);
        }
    }
}
