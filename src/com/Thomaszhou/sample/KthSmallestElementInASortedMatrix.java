package com.Thomaszhou.sample;
/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n-1][n-1];

        while(min<=max){
            int mid = min + (max-min)/2;
            int count = countLessEqual(matrix, mid);
            if (count < k)
                min = mid + 1;
            else{
                max = mid-1;
            }
        }
        return min;
    }

    private int countLessEqual(int[][] matrix, int mid){
        int count = 0;
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j< matrix.length){
            if (matrix[i][j] <= mid){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }
}
