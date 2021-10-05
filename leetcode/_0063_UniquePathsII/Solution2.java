package leetcode._0063_UniquePathsII;

// 二维dp
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // cc
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) {
                    dp[i][j] = 1;
                    continue;
                }
                
                int right = j + 1 > n-1 ? 0 : obstacleGrid[i][j+1] == 1 ? 0 : dp[i][j+1];
                int down = i + 1 > m-1 ? 0 : obstacleGrid[i+1][j] == 1 ? 0 : dp[i+1][j];
                dp[i][j] = right + down;
            }
        }
        
        return dp[0][0];
    }
}

// time: O(m*n); space: O(m*n);
