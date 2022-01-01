package leetcode._0931_MinimumFallingPathSum;

// 二维dp
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        // cc
        
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int j = 0; j < col; j++)
            dp[row-1][j] = matrix[row-1][j];
        
        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = dp[i+1][j] + matrix[i][j]; // dp[i][j]初始化
                for (int k = j-1; k <= j+1; k++) {
                    if (k >= 0 && k < col)
                        dp[i][j] = Math.min(dp[i+1][k] + matrix[i][j], dp[i][j]);
                }
            }
        }
        
        int minSum = dp[0][0];
        for (int j = 1; j < col; j++)
            minSum = Math.min(dp[0][j], minSum);
        
        return minSum;
    }
}

// time: O(m*n); space: O(m*n);
