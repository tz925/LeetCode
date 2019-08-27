package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;


public class FindDisappearedNumbers {
//    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//
//    Find all the elements of [1, n] inclusive that do not appear in this array.
//
//    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
//
//    Example:
//
//    Input:
//            [4,3,2,7,8,2,3,1]
//
//    Output:
//            [5,6]
    public static List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> allNum = new ArrayList<>();
//        List<Integer> have = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        for (int i = 1; i <= nums.length; i++){
//            allNum.add(i);
//            have.add(nums[i-1]);
//        }
//        for(int n: allNum){
//            if (!have.contains(n)){
//                result.add(n);
//            }
//        }
//        return result;

        //Time O(n) Space O(n) Uses an extra boolean[] to store seen values as we go through array.
//        List<Integer> result = new ArrayList<>();
//        boolean[] thereIs = new boolean[nums.length];
//        for(int i: nums){
//            thereIs[i-1] = true;
//        }
//        for(int i=0;i<thereIs.length;i++){
//            if (!thereIs[i]){
//                result.add(i+1);
//            }
//        }
//        return result;

        //Time O(n) Space(1) use no extra space by adding length n to value at corresponding position
        // This way does not affect value lookup after by modulo values by n (the result is original value)
        // anything in the array that !< n means it is not seen (disappeared)
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for(int x: nums){
            nums[(x-1) % n] += n;
        }
        for(int i=0; i<n;i++){
            if (nums[i] <= n){
                result.add(i+1);
            }
        }
        return result;
    }
}
