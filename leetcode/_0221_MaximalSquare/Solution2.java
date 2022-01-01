package leetcode._0221_MaximalSquare;

// O(n) dp
class Solution2 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) throw new IllegalArgumentException();
        
        int row = matrix.length, col= matrix[0].length, max = 0;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            int[] cur = new int[col];
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    cur[j] = 1;
                    if (i - 1 >= 0 && j - 1 >= 0 && cur[j-1] != 0 && dp[j-1] != 0 && dp[j] != 0) {
                        cur[j] = Math.min(cur[j-1], Math.min(dp[j-1], dp[j]))+ 1;
                    }
                    max = Math.max(max, cur[j]);
                }
            }
            dp = cur;
        }
        
        return max*max;
    }
}

// time: O(m*n); space: O(m);
