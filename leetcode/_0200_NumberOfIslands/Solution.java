package leetcode._0200_NumberOfIslands;

// dfs
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null) return 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int row = grid.length, col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || grid[i][j] == '0')
            return;
        
        visited[i][j] = true;
        dfs(grid, i+1, j, visited);
        dfs(grid, i-1, j, visited);
        dfs(grid, i, j+1, visited);
        dfs(grid, i, j-1, visited);
    }
}
// time: dfs O(mn)长治久安，每个点最多被摸两次; space: O(mn)