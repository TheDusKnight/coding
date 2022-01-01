package leetcode._0931_MinimumFallingPathSum;

// 一维dp rolling array
class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        // cc
        
        int row = matrix.length, col = matrix[0].length;
        int[] dp = new int[col];
        for (int j = 0; j < col; j++) dp[j] = matrix[row-1][j];
        
        for (int i = row-2; i >= 0; i--) {
            int[] next = new int[col];
            for (int j = 0; j < col; j++) {
                next[j] = dp[j] + matrix[i][j];
                for (int k = j-1; k <= j+1; k++) {
                    if (k >= 0 && k < col)
                        next[j] = Math.min(next[j], dp[k] + matrix[i][j]);
                }
            }
            dp = next;
        }
        
        int minSum = dp[0];
        for (int j = 1; j < col; j++)
            minSum = Math.min(dp[j], minSum);
        
        return minSum;
    }
}

// time: O(m*n); space: O(m*n);
