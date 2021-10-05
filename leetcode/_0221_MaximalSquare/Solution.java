package leetcode._0221_MaximalSquare;

// 二维dp
class Solution {
    public int maximalSquare(char[][] matrix) {
        // cc
        
        int max = 0;
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    if (i-1 >= 0 && j-1 >= 0) {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        return max * max;
    }
}

// time: O(m*n); space: O(m*n);
