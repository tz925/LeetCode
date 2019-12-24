package com.Thomaszhou.sample.ArrayAndStrings;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    static final int R = 0;
    static final int D = 1;
    static final int L = 2;
    static final int U = 3;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return ans;
        int col = matrix[0].length;
        int direction = R;
        int k = 0; // counter for how many cell we have proceeded.
        int i = 0, j = 0;
        int upbound = -1;
        int rightbound = col;
        int bottombound = row;
        int leftbound = -1;
        while(k < row*col){
            ans.add(matrix[i][j]);
            switch (direction){
                case R:
                    if (j+1 >= rightbound){
                        upbound += 1;
                        direction = D;
                        i+=1;
                    }else{
                        j+=1;
                    }
                    break;
                case D:
                    if (i+1 >= bottombound){
                        rightbound -= 1;
                        direction = L;
                        j-=1;
                    }else{
                        i+=1;
                    }
                    break;
                case L:
                    if (j-1 <= leftbound){
                        bottombound -= 1;
                        direction = U;
                        i-=1;
                    }else{
                        j-=1;
                    }
                    break;
                case U:
                    if (i-1 <= upbound){
                        leftbound += 1;
                        direction = R;
                        j+=1;
                    }else{
                        i-=1;
                    }
                    break; default: break;
            }

            k++;
        }

        return ans;
    }
}
