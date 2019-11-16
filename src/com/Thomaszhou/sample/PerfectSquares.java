package com.Thomaszhou.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class PerfectSquares {
    public int numSquares(int n) {
        //DP 21ms 65.22% 35.5MB 18.05%
//        int[] countSqr = new int[n+1];
//        Arrays.fill(countSqr, Integer.MAX_VALUE);
//
//        countSqr[0] = 0;
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j*j <= i; j++) {
//                countSqr[i] = Math.min(countSqr[i], countSqr[i-j*j]+1);
//            }
//        }
//
//        return countSqr[n];

//        ------------------------------------------------------

        //Mathematical Lagrange's Four Square theory, there are only 4 possible result 1,2,3,4
        // 1ms 100% 33.6MB 94.44%

        if (isSquare(n)) return 1; //if n is a perfect square, return 1.

        while(n % 4 == 0) n >>= 2;

        if (n % 8 == 7) return 4;

        double sqrt = Math.sqrt(n);
        for (int i = 1; i < sqrt; i++) {
            if (isSquare(n - i*i)) return 2;
        }
        return 3;

//        ------------------------------------------------------



    }

    private boolean isSquare(int n){
        double sqrt_n = Math.sqrt(n);
        return Math.round(sqrt_n)==sqrt_n;
    }
}
