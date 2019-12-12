package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArray2 {
    public int[] intersect(int[] nums1, int[] nums2){
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int k: nums1) {
            map.put(k, map.getOrDefault(k, 0)+1);
        }

        for (int k: nums2) {
            int count = map.getOrDefault(k, 0);
            if (count > 0) {
                result.add(k);
                map.put(k,map.get(k)-1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
