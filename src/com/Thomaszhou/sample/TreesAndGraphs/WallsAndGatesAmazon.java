package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Queue;

/*
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example:

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
 */
public class WallsAndGatesAmazon {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return ;

        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        int R = rooms.length; int C = rooms[0].length;

        //set up BFS queue
        Queue<Integer> queue = new ArrayDeque<>();
        // will use rooms as depth Map.

        //push all door (0) to queue
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (rooms[r][c] == 0){
                    queue.offer(r * C + c);
                }
            }
        }

        //BFS
        while(!queue.isEmpty()){
            int cur_location = queue.remove();
            int row = cur_location / C;
            int col = cur_location % C;
            int cur_depth = rooms[row][col];
            for (int i = 0; i < 4; i++) {
                int nc = col+dc[i];
                int nr = row+dr[i];
                if (0 <= nc && nc < C && 0 <= nr && nr < R && rooms[nr][nc] == Integer.MAX_VALUE){
                    rooms[nr][nc] = cur_depth + 1;
                    queue.offer(nr * C + nc);
                }
            }
        }

        // void done
    }
}
