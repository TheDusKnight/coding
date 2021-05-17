package leetcode._0417_PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// bfs 两次，一次从太平洋一次从大西洋，边走边check
public class Solution {
    int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int row, col;

    private void bfs(int[][] heights, Queue<Integer> queue, boolean[][] self, boolean[][] other,
            List<List<Integer>> res) {
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;

            if (other[i][j]) {
                res.add(Arrays.asList(i, j));
            }

            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];

                if (ii >= 0 && ii < row && jj >= 0 && jj < col && heights[ii][jj] >= heights[i][j] && !self[ii][jj]) {
                    queue.offer(ii * col + jj);
                    self[ii][jj] = true;
                }
            }
        }
    }

    private void loadAllPacificStartPoints(int[][] heights, Queue<Integer> queue, boolean[][] pacific) {
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                for (int j = 0; j < col; j++) {
                    queue.offer(i * col + j);
                    // 记得set成true
                    pacific[i][j] = true;
                }
            } else {
                queue.offer(i * col + 0);
                pacific[i][0] = true;
            }
        }
    }

    private void loadAllAtlanticStartPoints(int[][] heights, Queue<Integer> queue, boolean[][] atlantic) {
        for (int i = 0; i < row; i++) {
            if (i == row - 1) {
                for (int j = 0; j < col; j++) {
                    queue.offer(i * col + j);
                    atlantic[i][j] = true;
                }
            } else {
                queue.offer(i * col + (col - 1));
                atlantic[i][col - 1] = true;
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0)
            return res;

        row = heights.length;
        col = heights[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        loadAllPacificStartPoints(heights, queue, pacific);
        bfs(heights, queue, pacific, atlantic, res);
        loadAllAtlanticStartPoints(heights, queue, atlantic);
        bfs(heights, queue, atlantic, pacific, res);

        return res;
    }
}

// time: O(m*n); space: O(m*n);