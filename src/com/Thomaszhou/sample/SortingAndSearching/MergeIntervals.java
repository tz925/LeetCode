package com.Thomaszhou.sample.SortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][];
        int resultIndex = 0;
        if (intervals.length == 0) return result;

        //sorting
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // overlap
            if (left <= intervals[i][1] && right >= intervals[i][0]){
                if (left > intervals[i][0]) left = intervals[i][0];
                if (right < intervals[i][1]) right = intervals[i][1];
            }else{
                result[resultIndex] = new int[]{left, right};
                resultIndex++;
                left = intervals[i][0]; right = intervals[i][1];
            }
        }
        result[resultIndex] = new int[]{left, right};
        resultIndex++;

        //to copy only non null values
        result = Arrays.copyOfRange(result, 0, resultIndex);

        return result;
    }



}
