package com.Thomaszhou.sample.Math;
/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 the number of 1's in their binary representation and return them as an array.
 */
public class CountBits {
    //time(n) space(n)
    public int[] countBits(int num) {
        int[] f = new int[num+1];
        for(int i=0; i<=num; i++){
            f[i] = f[(int)Math.floor(i/2)] + i % 2;
        }
        return f;
    }
}
