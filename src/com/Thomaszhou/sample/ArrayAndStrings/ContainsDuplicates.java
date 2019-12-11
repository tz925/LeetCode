package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }
        return set.size() != nums.length;
    }
}
