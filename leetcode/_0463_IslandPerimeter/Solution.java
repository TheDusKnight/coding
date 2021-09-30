package leetcode._0463_IslandPerimeter;

// 2d matrix
class Solution {
    public int islandPerimeter(int[][] grid) {
        // cc
        
        int count = 0;
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i-1 == -1 || grid[i-1][j] == 0) count++;
                    if (i+1 == row || grid[i+1][j] == 0) count++;
                    if (j-1 == -1 || grid[i][j-1] == 0) count++;
                    if (j+1 == col || grid[i][j+1] == 0) count++;
                }
            }
        }
        
        return count;
    }
}

// time: O(N); space: O(1);
