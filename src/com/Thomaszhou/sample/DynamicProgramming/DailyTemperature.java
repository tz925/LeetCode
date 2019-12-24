package com.Thomaszhou.sample.DynamicProgramming;

import java.util.*;

/*
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        //burte force for t in T, find higher element after t's position. time n^2

        // loop backward.
        // build a int[] to remember which index we last saw some temperature
        int[] last = new int[101];
        int[] result = new int[T.length];
        Arrays.fill(last, Integer.MAX_VALUE);
        for (int i = T.length-1; i >= 0 ; i--) {

            int warm = Integer.MAX_VALUE;
            for(int j = T[i] + 1; j <= 100; j++){
                if (last[j]>=i && last[j]< warm){
                    warm = last[j];
                }
            }
            if(warm < Integer.MAX_VALUE){
                result[i] = warm - i;
            }
            last[T[i]] = i; //recording index we have seen this temperature
        }

        return result;
    }

}
