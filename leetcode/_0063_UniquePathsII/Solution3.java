package leetcode._0063_UniquePathsII;

// O(0) dp 速度最快
class Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // cc
        
        int[][] grid = obstacleGrid;
        int row = grid.length, col = grid[0].length;
        
        if (grid[row-1][col-1] == 1) return 0;
        grid[row-1][col-1] = 1;
        for (int i = col-2; i >= 0; i--) grid[row-1][i] = grid[row-1][i] == 0 && grid[row-1][i+1] == 1 ? 1 : 0;
        
        for (int i = row-2; i >= 0; i--) {
            grid[i][col-1] = grid[i][col-1] == 0 ? grid[i+1][col-1] : 0;
            for (int j = col-2; j >= 0; j--) {
                grid[i][j] = grid[i][j] == 0 ? grid[i+1][j] + grid[i][j+1] : 0;
            }
        }
        
        return grid[0][0];
    }
}

// time: o(m*n); space: O(1);
