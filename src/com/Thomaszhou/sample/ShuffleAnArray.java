package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */
public class ShuffleAnArray {
    private int[] original;

    public ShuffleAnArray(int[] nums) {
        original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            int index;
            do {
                index = random.nextInt(original.length);
            }while(result.contains(original[index]));
            result.add(original[index]);
        }

        int[] ans = new int[original.length];
        for (int i = 0; i < original.length; i++) {
             ans[i] = result.get(i);
        }

        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
