package com.Thomaszhou.sample;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        String s = "A man, a plan, a canal: Panama";
//        s = s.replaceAll("[^\\w]", "");
//        System.out.println(s);
//        s = s.replaceAll("/s","");
//        System.out.println(s);
//        int a = 5;
//        int b = a;
//        b = 10;
//        System.out.println(a);
//        System.out.println(b);
//        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
//        image = FloodFill.floodFill(image, 1,1, 2);
//        for(int[] i : image){
//            for(int j : i){
//                System.out.println(j);
//            }
//        }
//        System.out.println("45: " +  5.0/3);
//
//        UniquePaths up = new UniquePaths();
//        System.out.println(up.uniquePaths(4,7));

//        Search2DMatrixII sm = new Search2DMatrixII();
//        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        System.out.println(sm.searchMatrix(matrix, 20));

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch ws = new WordSearch();
        System.out.println(ws.exist(board, "ABCCED"));
    }
}
