package leetcode._0542_01Matrix;

import java.util.*;

// 和先构造LC286 2d matrix，再找最短路径
public class Solution {
    private static int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void addAllZeros(int[][] matrix, Queue<Integer> queue, int[][] res) {
        // 问面试管是否存在出界的情况?
        int colLen = matrix[0].length;
        for (int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    queue.offer(i * colLen + j);
                }
            }
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            // throw new IllegalArgumentException();
            return matrix;
        }

        int[][] res = new int[matrix.length][matrix[0].length];
        int col = matrix[0].length, row = matrix.length;
        Queue<Integer> queue = new LinkedList<>();
        addAllZeros(matrix, queue, res);
        // int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col) {
                        // queue.offer(ii * col + jj);
                        // matrix[ii][jj] = minLen;
                        if (res[ii][jj] > res[i][j] + 1) {
                            queue.offer(ii * col + jj);
                            res[ii][jj] = res[i][j] + 1;
                        }
                    }
                }
            }
            // minLen++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Solution sol = new Solution();
        int[][] res = sol.updateMatrix(matrix);
        for (int[] row : res) {
            System.out.println(Arrays.toString(row));
        }
    }
}