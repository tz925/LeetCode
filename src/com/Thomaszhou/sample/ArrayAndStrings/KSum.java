package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.ArrayList;
import java.util.List;

// note the nums should have been sorted before hand.
public class KSum {
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
