package com.Thomaszhou.sample.DynamicProgramming;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {
    //basically fibonacci
    // Recursive too slow on large input.
//    public int rob(int[] nums) {
//        return robHelper(nums, 0);
//    }
//
//    private int robHelper(int[] nums, int startIndex){
//        if (startIndex >= nums.length){
//            return 0;
//        }else if (startIndex+1 >= nums.length){
//            return nums[startIndex];
//        }
//        return Math.max(robHelper(nums, startIndex+2)+nums[startIndex], robHelper(nums, startIndex+3)+nums[startIndex+1]);
//    }

    // use a array to store max total robbed value possible when rob #n house. (Dynamic programming)
    // we can just for loop once and then refer to the larger of last two index in the stored value.
    //faster than 100%, space less than 100% on leetcode. time(n) space(n) for storing n int in array.

//    private int[] haveRobbed;
//    public int rob(int[] nums){
//        if (nums.length <= 0) return 0;
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return Math.max(nums[0], nums[1]);
//        // nums.length >= 3
//
//        haveRobbed = new int[nums.length];
//        haveRobbed[0] = nums[0];
//        haveRobbed[1] = nums[1];
//        haveRobbed[2] = nums[2] + haveRobbed[0];
//
//        for(int i = 3; i < nums.length; i++){
//            haveRobbed[i] = Math.max(haveRobbed[i-2], haveRobbed[i-3]) + nums[i];
//        }
//
//        return Math.max(haveRobbed[haveRobbed.length-1],haveRobbed[haveRobbed.length-2]);
//    }

    /*
    Even better we can just use two int to store last two value therefore space(1)
     */

    public int rob(int[] nums){
        int rob = 0;
        int notRob = 0;
        int curRob = 0;

        for(int i = 0; i < nums.length; i++){
            curRob = notRob + nums[i];
            notRob = Math.max(rob, notRob); //if not robbing this one, take max of rob i-1th, or notRob i-1th.
            rob = curRob;
        }

        return Math.max(rob,notRob);
    }
}
