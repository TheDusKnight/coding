package leetcode._0778_SwimInRisingWater;

import java.util.PriorityQueue;

// Idea is similar to Dijkstra's algorithm. Each iteration, we will select the neighbouring cell which is having least water level.
// Once we selected it, we will push all of its neighbors, that have not visited to the priority queue. Complexity will be O(N2 log N)

// Amazon OA
class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (grid[a[0]][a[1]] - grid[b[0]][b[1]]));
        pq.add(new int[] { 0, 0 });
        int lev = 0;
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            lev = Math.max(lev, grid[cur[0]][cur[1]]);
            if (cur[0] == N - 1 && cur[1] == N - 1)
                return lev;

            for (int[] dir : DIRECTIONS) {
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if (i >= 0 && i < N && j >= 0 && j < N && !visited[i][j]) {
                    visited[cur[0]][cur[1]] = true;
                    pq.add(new int[] { i, j });
                }
            }
        }
        return lev;
    }
}