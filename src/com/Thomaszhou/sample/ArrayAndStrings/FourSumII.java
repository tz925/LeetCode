package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there
are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of
-228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {
    //Brute Force: 4 for loops Time(n^4)

    // Time(n^2) Space O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i]+B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -C[i]-D[j];
                count += map.getOrDefault(sum,0);
            }
        }

        return count;
    }
}
