package leetcode._0695_MaxAreaOfIsland;

import java.util.LinkedList;
import java.util.Queue;

// bfs, keep global max
public class Solution {
    int row;
    int col;
    int max;
    static final int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;

        row = grid.length;
        col = grid[0].length;
        max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                }
            }
        }
        return max;
    }

    private void bfs(int[][] grid, int r, int c) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r * col + c);
        grid[r][c] = 0;
        int localCount = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;
            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && grid[ii][jj] == 1) {
                    grid[ii][jj] = 0;
                    queue.offer(ii * col + jj);
                    localCount++;
                }
            }
        }
        max = Math.max(max, localCount);
    }
}

// time: O(m*n); space: O(m*n);