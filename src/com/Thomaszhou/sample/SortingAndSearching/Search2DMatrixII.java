package com.Thomaszhou.sample.SortingAndSearching;

import java.util.Arrays;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
 */
public class Search2DMatrixII {
    // O(mn) double for loop through, can "continue" to look next row earlier.

    //O(mlogn) binary search each row

    // use the special properties, we check last element of each row. until we find something larger than target
    // then we dont need to check any row before this row, similar for column, therefore reduce search space.
    // this operation cost, O(m+n).
    //yet this is slow somehow... 7ms 18.22%
    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        if (m == 0) return false;
//        int n = matrix[0].length;
//        if (n == 0) return false;
//        int rowStart = 0; int colStart = 0;
//
//        //looking for start point in rol and col to reduce potential search spece
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][n-1] == target) return true;
//            else if (matrix[i][n-1] > target) {
//                rowStart = i;
//                break;
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (matrix[m-1][i] == target) return true;
//            else if (matrix[m-1][i] > target) {
//                colStart = i;
//                break;
//            }
//        }
//
//        //look for target, for each row within rowStart & m, do binary search within colStart & n
//        for (int i = rowStart; i < m; i++) {
//            if (Arrays.binarySearch(Arrays.copyOfRange(matrix[i], colStart, n), target) >= 0) return true;
//        }
//
//        return false;

        /*
        start search the matrix from top right corner, initialize the current position to top right corner,
         if the target is greater than the value in current position, then the target can not be in entire row
          of current position because the row is sorted, if the target is less than the value in current position,
           then the target can not in the entire column because the column is sorted too. We can rule out one row
            or one column each time, so the time complexity is O(m+n).
         */
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
