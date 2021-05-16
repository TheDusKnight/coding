package leetcode._0542_01Matrix;
import java.util.*;

// 2d board search
public class Solution2 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void addAllZeros(Queue<Integer> queue, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(i * matrix[0].length + j);
                }
            }
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return matrix;
            // throw new IllegalArgumentException();
        
        Queue<Integer> queue = new LinkedList<>();
        addAllZeros(queue, matrix);
        int row = matrix.length;
        int col = matrix[0].length;
        int minLen = 0; // current shortest distance
        int[][] res = new int[row][col];

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                int i = curr / col, j = curr % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col
                        && matrix[ii][jj] == 1 && res[ii][jj] == 0) {
                            queue.offer(ii * col + jj);
                            res[ii][jj] = minLen + 1;
                        }
                }
            }
            minLen++;
        }
        return res;
    }
}
// time: O(V+E) = O(m*n + 4*m*n) = O(m*n)
// time: O(m * n), space: O(m * n)