package com.Thomaszhou.sample.DynamicProgramming;
/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;

        //for each starting character in matrix

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, i, j,0,word)) return true;
            }
        }

        // we have not found any way to produce word.
        return false;
    }

    private boolean backtrack(char[][] board,int i, int j,int curIndex, String word){
        if (i >= board.length || i < 0) return false;
        if (j >= board[0].length || j < 0) return false;
        if(board[i][j] == '#') return false;

        char val = board[i][j];

        board[i][j] = '#';

        if (val != word.charAt(curIndex)) {
            // Current slot's value doesn't meet the requirement, set the value back. Fail fast.
            board[i][j] = val;
            return false;
        }

        // Last character has met the requirement, now check if we have reached the end of the word
        // If so, we are done
        if (curIndex == word.length() - 1) return true;

        // Move up
        if (backtrack(board ,i  - 1, j, curIndex + 1, word))
            return true;
        // Move down
        if (backtrack(board,i  + 1, j, curIndex + 1, word))
            return true;
        // Move left
        if (backtrack(board,i , j - 1, curIndex + 1, word))
            return true;
        // Move right
        if (backtrack(board,i, j + 1, curIndex + 1, word))
            return true;

        // We have explored all possible neighboors to go forward, none of them meet the requirment. set the value back
        board[i][j] = val;

        return false;
    }
}
