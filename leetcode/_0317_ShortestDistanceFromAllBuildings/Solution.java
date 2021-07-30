package leetcode._0317_ShortestDistanceFromAllBuildings;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 注意不应该把所有1一次性放进queue，否则需要三维的board更新cost求和
    int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;

        int row = grid.length, col = grid[0].length;
        int[][] cost = new int[row][col]; // reuse cost
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) { // 从1出发去找0
                    bfs(grid, i, j, cost);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, cost[i][j]);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs(int[][] grid, int x, int y, int[][] cost) {
        int row = grid.length, col = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * col + y);

        int minLen = 1;
        boolean[][] visited = new boolean[row][col];
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && !visited[ii][jj] && grid[ii][jj] == 0) { // 如果是1肯定不会visit
                        queue.offer(ii * col + jj);
                        visited[ii][jj] = true;
                        cost[ii][jj] += minLen;
                    }
                }
            }
            minLen++;
        }

        // 注意没有visited到的0 set成2
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    grid[i][j] = 2;
                }
            }
        }
    }
}

// time: m*n + k*m*n + m*n; space: m*n;