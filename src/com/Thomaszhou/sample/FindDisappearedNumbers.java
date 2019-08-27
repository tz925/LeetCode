package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
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

        //Time O(n) Space O(n)
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

        List<Integer> result = new ArrayList<>();
        for(int x: nums){
            System.out.println(x);
            System.out.println(x-1);
            nums[(x-1) % nums.length] += nums.length;
        }
        for(int i=0; i<nums.length;i++){
            if (nums[i] <= nums.length){
                result.add(i+1);
            }
        }
        return result;


    }
}
