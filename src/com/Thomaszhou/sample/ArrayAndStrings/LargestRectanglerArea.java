package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.




Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area = 10 unit.



Example:

Input: [2,1,5,6,2,3]
Output: 10
 */
public class LargestRectanglerArea {
    /*
    brute force with little optimization on finding minium bar height between i & j. n^2 solution.
     */
    public int largestRectangleArea1(int[] heights) {
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                maxarea = Math.max(maxarea, minheight * (j - i + 1));
            }
        }
        return maxarea;
    }
    /*
    divide and conquer
    Notice that the answer is determined by
    1. Min bar height in the range * range
    2. subproblem of the left of min bar,
    3. subproblem of the right of the min bar

    space(n) from call stack
    Average case : nlogn logn times call, which takes n steps(finding min)
    worst case (sorted array 012345): n^2, will call 0,5 1,5 2,5 3,5 4,5 5,5
     */
    public int largestRectangleArea2(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }

    public int helper(int[] heights, int start, int end){
        if (end < start) return 0;

        int maxarea = 0;
        int left = 0, right = 0;
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i <= end; i++) {
            if (minIndex == Integer.MAX_VALUE || heights[i] < heights[minIndex] ) minIndex = i;
        }

        int mid = heights[minIndex] * (end - start + 1);
        left = helper(heights, start, minIndex - 1);
        right = helper(heights, minIndex + 1, end);

        return Math.max(Math.max(left, right), mid);
    }

    /*
    how to improve the time for finding min from O(n)? Segment Tree. We can build (O(n)) a segment tree for segment min,
    then each time finding min will be O(logN)
    overall: build segment Tree(n) + worst case we have sorted array, function called n time, each time we do logn finding min,
    Best case, it will be n + logN times function call each time logn for finding min, = n + logN * LogN
     */

    /*
    using stack O(n)
    dont know what to say this is genius.
     */
    public int largestRectangleArea(int[] heights) {
        Stack< Integer > stack = new Stack <> ();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }
}
