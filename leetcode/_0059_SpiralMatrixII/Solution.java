package leetcode._0059_SpiralMatrixII;

// dfs
class Solution {
    int count;
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n < 1) return matrix;
        
        count = 1;
        dfs(matrix, 0, n);
        return matrix;
    }
    
    private void dfs(int[][] matrix, int offset, int n) {
        if (n == 1) {
            matrix[offset][offset] = count; // ?
            return;
        }
        if (n <= 0) {
            return;
        }
        
        for (int i = 0; i < n-1; i++) {
            matrix[offset][offset+i] = count++;
        }
        for (int i = 0; i < n-1; i++) {
            matrix[offset+i][offset+n-1] = count++;
        }
        for (int i = 0; i < n-1; i++) {
            matrix[offset+n-1][offset+n-1-i] = count++;
        }
        for (int i = 0; i < n-1; i++) {
            matrix[offset+n-1-i][offset] = count++;
        }
        
        dfs(matrix, offset+1, n-2);
    }
}
