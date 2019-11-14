package com.Thomaszhou.sample;
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //for each point we check for 1, then convert all connected 1 to 0.
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(i, j, grid);
                }
            }
        }

        return result;
    }

    private void dfs(int i, int j, char[][] grid){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||grid[i][j] != '1' ) return;
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i, j-1, grid);
        dfs(i+1,j,grid);
        dfs(i,j+1,grid);
    }
}
