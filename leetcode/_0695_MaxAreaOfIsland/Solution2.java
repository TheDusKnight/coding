package leetcode._0695_MaxAreaOfIsland;

// dfs，不用check出环，直接修改board阻止revisit
// 如果不让直接修改，keep一个boolean[][] visit，每次找到island，标记成visit。替代grid[i][j] = 0
public class Solution2 {
    int row, col;
    int max;
    int localCount;
    public int maxAreaOfIsland(int[][] grid) {
        // cc
        row = grid.length; col = grid[0].length;
        max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    localCount = 0;
                    dfs(grid, i, j);
                    max = Math.max(max, localCount);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 0) return;

        grid[i][j] = 0;
        localCount++;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);

    }
}

// time: O(m*n); space: O(m*n) stack