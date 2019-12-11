package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        /*
        This works, but exceed time limit when given large input.
         */
        if (nums.length <= 1) return true;
        int target = nums.length -1;
//        Map<Integer, ArrayList<Integer>> end2start = new HashMap<>();
//        // create map for each index, we have a list of indexes that can reach this index.
//        for (int i = 0; i < nums.length; i++) {
//            for (int k = 1; k <= nums[i]; k++){
//                ArrayList<Integer> temp = end2start.getOrDefault(i+k, new ArrayList<>());
//                temp.add(i);
//                end2start.put(i+k,temp);
//            }
//        }
//        System.out.println(end2start.toString());
//        //if there is not target in keySet it means there is no index can reach the target index.
//
//        //DFS using stack
//        Stack<Integer> stack = new Stack<>();
//        ArrayList<Integer> temp = end2start.getOrDefault(target, new ArrayList<>());
//        stack.addAll(temp);
//
//        while(!stack.empty()){
//            int cur = stack.pop();
//            if (cur == 0) return true;
//            temp = end2start.getOrDefault(cur, new ArrayList<>());
//            stack.addAll(temp);
//        }
//        return false;

        // DP. backward trace the nearest index that can reach last, update last, then move backward.
//        int last=target,i,j;
//        for(i=target-2;i>=0;i--){
//            if(i+nums[i]>=last) last=i;
//        }
//        return last==0;

        /*
        GREEDY
        forward trace furthest we can reach, return false when we see maxlocation is smaller
        than  i (current looking index) or update maxlocation to max index that i can reach.
         */
        int maxRange = 0;
        for (int k = 0; k < nums.length; k++) {
            if (maxRange < k) return false;
            maxRange = Math.max(k+nums[k], maxRange);
        }
        return true;
    }
}
