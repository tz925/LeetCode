package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.HashSet;
import java.util.Iterator;

public class SingleNumber {
//
//    Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
//    Note:
//
//    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int a = 0;
        int b = 0;
        for(int i=0;i< nums.length; i++) {
            b += nums[i];
            set.add(nums[i]);
        }
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            a = Integer.sum(a, (Integer) iter.next());
        }
        return a*2 - b;
    }
}
