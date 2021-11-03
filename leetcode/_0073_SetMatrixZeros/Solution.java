package leetcode._0073_SetMatrixZeros;

// matrix inplace
// They are using the first row and column as a memory to keep track of all the 0's in the entire matrix.
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        int row = matrix.length, col = matrix[0].length;
        boolean rowFlag = false, colFlag = false;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) rowFlag = true;
                    if (j == 0) colFlag = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        
        if (rowFlag) {
            for (int i = 0; i < col; i++)
                matrix[0][i] = 0;
        }
        if (colFlag) {
            for (int i = 0; i < row; i++)
                matrix[i][0] = 0;
        }
    }
}

// time: O(n*m); space: O(1);
