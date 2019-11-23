package com.Thomaszhou.sample;
/*

 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        /* run twice on O(mn) for loop
         first time set related cells to dummy value if they were not 0 before,
         second time set all -1 to 0;
         this is (MN + MN) and stupid if there is our dummmy value in the matrix, e.g. I used MIN_VALUE and it was in one of the test cases.
         2ms 44.63% and 43.3MB 95.71%
        */
//         if (matrix.length == 0 || matrix[0].length == 0) return;
//         for(int i = 0; i < matrix.length; i++){
//             for(int j=0; j < matrix[0].length; j++){
//                 if(matrix[i][j] == 0){
//                     for(int k=0; k<matrix.length;k++){
//                         if(matrix[k][j] != 0) matrix[k][j] = -100000;
//                     }
//                     for(int k=0; k<matrix[0].length;k++){
//                         if(matrix[i][k] != 0) matrix[i][k] = -100000;
//                     }
//                 }
//             }
//         }

//         for(int i = 0; i < matrix.length; i++){
//             for(int j=0; j < matrix[0].length; j++){
//                if(matrix[i][j] == -100000) matrix[i][j] = 0;
//             }
//         }

        /*
        smarter solution improve from first one.
        because the way for loop go through the matrix, when we look at matrix[i][j] we must have
        looked at (0,j) and (i,0) already. so setting them to zero wont affect later execution

        later we look at first row and column for zeros and set their leading row or column to zeros
        */
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
