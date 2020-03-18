package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.



Example 1:



Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottingOrangesAmazon {
    public int orangesRotting(int[][] grid) {
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        int R = grid.length; int C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        // put in all rotting tamato (2)
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.offer(code);
                    depth.put(code, 0);
                }
            }
        }

        //BFS
        int ans_depth = 0;

        while(!queue.isEmpty()){
            int cur_code = queue.remove();
            int row = cur_code / C;
            int col = cur_code % C;
            int cur_depth = depth.get(cur_code);
            for (int i = 0; i < 4; i++) {
                int nc = col+dc[i];
                int nr = row+dr[i];
                if (nc >= 0 && nc < C && nr >= 0 && nr < R && grid[nr][nc] == 1){
                    // found a good tomato
                    // rot it
                    grid[nr][nc] = 2;
                    int new_code = nr*C+nc;
                    queue.offer(new_code);
                    depth.put(new_code, cur_depth+1);
                    ans_depth = cur_depth+1;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) return -1;
            }
        }

        return ans_depth;

    }
}
