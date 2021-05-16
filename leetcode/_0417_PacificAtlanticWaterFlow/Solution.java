package leetcode._0417_PacificAtlanticWaterFlow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// bfs 两次，一次从太平洋一次从大西洋，边走边check
class Solution {
    private final static int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void loadAllPacificStartPoints(int[][] matrix, Queue<Integer> queue, boolean[][] pacific, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (i == 0) {
                for (int j = 0; j < col; j++) {
                    // queue.offer(matrix[i][j]);
                    queue.offer(i * col + j);
                    pacific[i][j] = true;
                }
            } else {
                // queue.offer(matrix[i][0]);
                queue.offer(i * col + 0);
                pacific[i][0] = true;
            }
        }
    }

    private void loadAllAtlanticStartPoints(int[][] matrix, Queue<Integer> queue, boolean[][] atlantic, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (i == row - 1) {
                for (int j = 0; j < col; j++) {
                    // queue.offer(matrix[i][j]);
                    queue.offer(i * col + j);
                    atlantic[i][j] = true;
                }
            } else {
                // queue.offer(matrix[i][col - 1]);
                queue.offer(i * col + (col - 1));
                atlantic[i][col - 1] = true;
            }
        }
    }

    private void bfs(int[][] matrix, Queue<Integer> queue, boolean[][] self, boolean[][] another,
            List<List<Integer>> res, int row, int col) {
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int i = curr / col, j = curr % col;

            if (another[i][j])
                res.add(Arrays.asList(i, j));

            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[ii][jj] >= matrix[i][j] && !self[ii][jj]) {
                    queue.offer(ii * col + jj);
                    self[ii][jj] = true;
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length, col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];

        loadAllPacificStartPoints(matrix, queue, pacific, row, col);
        // for (boolean[] i : pacific) {
        //     System.out.println(Arrays.toString(i));
        // }
        bfs(matrix, queue, pacific, atlantic, res, row, col);
        loadAllAtlanticStartPoints(matrix, queue, atlantic, row, col);
        // for (boolean[] i : atlantic) {
        //     System.out.println(Arrays.toString(i));
        // }
        bfs(matrix, queue, atlantic, pacific, res, row, col);
        return res;

    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(sol.pacificAtlantic(matrix));
    }
}

// time: O(m*n); space: O(m*n);