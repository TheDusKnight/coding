package leetcode._0317_ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    private int row, col;
    private int[][] cost;
    private static final int[][] DIRECTIONS = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int shortestDistance(int[][] grid) {
        // cc
        row = grid.length;
        col = grid[0].length;
        cost = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, i, j);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    minCost = Math.min(minCost, cost[i][j]);
                }
            }
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public void bfs(int[][] grid, int r, int c) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(r * col + c);
        int minLen = 1;
        boolean[][] visited = new boolean[row][col];

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && !visited[ii][jj] && grid[ii][jj] == 0) {
                        cost[ii][jj] = minLen;
                        visited[ii][jj] = true;
                    }
                }
            }
            minLen++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    grid[i][j] = 2;
                }
            }
        }
    }
}
