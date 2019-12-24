package com.Thomaszhou.sample.BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a collection of distinct integers, return all possible permutations.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        backTracking(ans, new ArrayList<>(), nums);
        return ans;
    }

    private void backTracking(List<List<Integer>> ans, List<Integer> tempList, int[] nums){
        if (tempList.size() == nums.length)
            ans.add(new ArrayList<>(tempList));
        else{
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backTracking(ans, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
