package com.Thomaszhou.sample.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to
 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegions {
    protected Integer ROWS = 0;
    protected Integer COLS = 0;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<Integer> startingBorders = new LinkedList<>();
        // Step 1). construct the list of starting border cells
        for (int r = 0; r < this.ROWS; ++r) {
            if(board[r][0] == 'O') startingBorders.add(r*COLS);
            if(board[r][COLS - 1] == 'O') startingBorders.add(r*COLS+COLS-1);
        }
        for (int c = 0; c < this.COLS; ++c) {
            if(board[0][c] == 'O') startingBorders.add(c);
            if(board[ROWS - 1][c] == 'O') startingBorders.add(COLS*(ROWS - 1)+c);
        }

        // Step 2). mark the escaped cells
        for (Integer index : startingBorders) {
            DFS(board, index);
        }

        // Step 3). flip the cells to their correct final states
        for (int r = 0; r < this.ROWS; ++r) {
            for (int c = 0; c < this.COLS; ++c) {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                if (board[r][c] == 'E')
                    board[r][c] = 'O';
            }
        }
    }

    protected void DFS(char[][] board, int index) {
        int row = index / COLS;
        int col = index % COLS;
        if (board[row][col] != 'O')
            return;

        board[row][col] = 'E';
        if (col < this.COLS - 1)
            this.DFS(board, index+1);
        if (row < this.ROWS - 1)
            this.DFS(board, index+COLS);
        if (col > 0)
            this.DFS(board, index-1);
        if (row > 0)
            this.DFS(board, index-COLS);
    }
}

