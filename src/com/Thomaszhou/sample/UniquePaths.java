package com.Thomaszhou.sample;
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 */
public class UniquePaths {
    int result = 0;

    public int uniquePaths(int m, int n) {
        //backtracking
//        backTracking(m-1, n-1); //because 2x2 grid we can only move down and right once.
//        return result;

        //DP
        int[][] grid = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0||j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];


    }

    public void backTracking(int m, int n){
        if (m == 0 && n == 0) {result+=1;}
        else {
            if(m > 0) backTracking(m - 1, n);
            if (n> 0)backTracking(m, n - 1);
        }
    }


}
