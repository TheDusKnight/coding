package leetcode._0064_MinimumPathSum;

// O(0) dp，和unique path逻辑一样
class Solution2 {
    public int minPathSum(int[][] grid) {
        // cc
        if (grid == null || grid.length == 0 || grid[0].length == 0) throw new IllegalArgumentException();
        
        int row = grid.length, col = grid[0].length;
        for (int i = col-2; i >= 0; i--) {
            grid[row-1][i] += grid[row-1][i+1];
        }
        
        for (int i = row-2; i >= 0; i--) {
            grid[i][col-1] += grid[i+1][col-1];
            for (int j = col-2; j >= 0; j--) {
                grid[i][j] += Math.min(grid[i+1][j], grid[i][j+1]);
            }
        }
        
        return grid[0][0];
    }
}

// time: O(m*n); space: O(1);
