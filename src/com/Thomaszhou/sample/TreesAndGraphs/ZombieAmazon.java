package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?

Example:

Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
int minHours(int rows, int columns, List<List<Integer>> grid) {

}
 */
public class ZombieAmazon {
    public static void main(String[] args) {
        int rows = 4, columns = 5;
        int[][] grid = new int[][]{
                {0, 1, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0}
        };

        System.out.println(minHours(rows, columns, grid));
    }

    public static int minHours(int rows, int columns, int[][] grid) {
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        Queue<Integer> queue = new ArrayDeque<>();
        int[][] depth = new int[rows][columns];


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if(grid[r][c] == 1) queue.offer(r*columns + c);
            }
        }

        int ans = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int row = cur / columns;
            int col = cur % columns;
            int cur_depth = depth[row][col];
            for (int i = 0; i < 4; i++) {

                int nr = row + dr[i];
                int nc = col + dc[i];
                if (0 <= nr && nr < rows && 0 <= nc && nc < columns && grid[nr][nc] == 0){
                    grid[nr][nc] = 1;
                    depth[nr][nc] = cur_depth + 1;
                    ans = depth[nr][nc];
                    queue.offer(nr * columns + nc);
                }
            }
        }

        return ans;
    }
}
