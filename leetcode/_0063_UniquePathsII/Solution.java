package leetcode._0063_UniquePathsII;

// recursion
class Solution {
    int[][] obstacleGrid;
    int m;
    int n;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // cc
        
        this.obstacleGrid = obstacleGrid;
        m = obstacleGrid.length;;
        n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1) return 0; // 注意确认终点是否有障碍物
        
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        
        return helper(0, 0);
    }
    
    private int helper(int i, int j) {
        if (i == m-1 && j == n-1) {
            return 1;
        }
        if (i > m-1 || j > n-1) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        
        if (memo[i][j] != -1) return memo[i][j];
        
        int right = helper(i, j+1);
        int down = helper(i+1, j);
        
        memo[i][j] = right + down;
        return memo[i][j];
    }
}

// time: O(m*n); space: O(m*n);
