package com.Thomaszhou.sample.Design;
/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 */
class NumMatrix {
    int[][] mMatrix = null; // our copy of matrix
    int m=0;//ROWS
    int n=0; //COLS

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        mMatrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        // rowSums[i][j] = rowSums[i][0] + rowSums[i][1] + ... + rowSums[i][j]
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
            }
        }
    }
    // O(n)
    public void update(int row, int col, int val) {
        // handle col = 0 differently
        int originalValue = col == 0 ? mMatrix[row][0] : mMatrix[row][col] - mMatrix[row][col - 1];
        int diff = val - originalValue;
        for (int j = col; j < n; j++) {
            mMatrix[row][j] += diff;
        }
    }

    // O(m)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // when col != 0, rowsum[i] = mMatrix[i][col2] - mMatrix[i][col1 - 1]
        // if col == 0, rowsum[i] = mMatrix[i][col2]
        int result = 0;
        for (int i = row1; i <= row2; i++) {
            // handle col = 0 differently
            result += col1 == 0 ? mMatrix[i][col2] : mMatrix[i][col2] - mMatrix[i][col1 - 1];
        }
        return result;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
/*
solution 2, BIT, binary indexed Tree.
 */
class NumMatrixBIT {
    // Instance variables
    int[][] tree;   // bit tree, sumNums(0->i) will be stored at tree(i+1), tree is reference by Length
    int[][] nums;   // a deep clone of the input matrix. otherwise matrix might be updated by other process
    int m;          // num of rows
    int n;          // num of cols

    // Constructor initialization
    public NumMatrixBIT(int[][] matrix) {
        // input checks
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // initialize variables
        m = matrix.length;
        n = matrix[0].length;
        tree = new int[m+1][n+1];
        // deep clone matrix for reference, to prevent other process change matrix
        nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j, matrix[i][j]);
            }
        }
    }

    // Function similar to Map.put(Key, Val), key is (row, col), new value is (val)
    public void update(int row, int col, int val) {
        // input validation: empty matrix || row col not in range
        if (m == 0 || n == 0 || row < 0 || row > m || col < 0 || col > n) {
            return;
        }
        // update cloned matrix: nums
        int oldVal = nums[row][col];
        nums[row][col] = val;
        // update bit tree with delta
        int delta = val - oldVal;
        for (int i = row + 1; i <= m; i += i & (-i)) {  // remember tree is indexed by rLen & cLen, off-by-one index
            for (int j = col + 1; j <= n; j += j & (-j)) {
                tree[i][j] += delta;
            }
        }
    }

    // Assume row1 <= row2 and col1 <= col2. both 0-base index and all input within range
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // input validation: empty matrix || row col not in range
        if (m == 0 || n == 0 || row1 < 0 || row1 > m || col1 < 0 || col1 > n || row2 < 0 || row2 > m || col2 < 0 || col2 > n) {
            return 0;
        }
        // used 4 rectangle areas [(0, 0), (x, y)] to compute wanted area
        // think about cases where row1 || col1 might be 0
        return sum(row2, col2) + sum(row1 - 1, col1 - 1) - sum(row1 - 1, col2) - sum(row2, col1 - 1);
    }

    public int sum(int row, int col) {
        // remember tree is indexed by rLen & cLen, off-by-one index
        int rLen = row + 1;
        int cLen = col + 1;
        int sum = 0;
        for (int i = rLen; i > 0; i -= i & (-i)) {
            for (int j = cLen; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }
}