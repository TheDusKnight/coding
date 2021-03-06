package leetcode._0378_KthSmallestElementInASortedMatrix;
import java.util.PriorityQueue;

// bfs + min-heap。可以但是有更好的方法
public class Solution {
    private static final int[][] DIRECTIONS = {{1,0}, {0,1}};

    public int kthSmallest(int[][] matrix, int k) {
        // cc throw exception?

        int row = matrix.length, col = matrix[0].length;
        // 最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (i, j) -> (matrix[i / col][i % col] - matrix[j / col][j % col]));
        boolean[][] visited = new boolean[row][col];

        queue.offer(0);
        int res = 0;

        // 只要做k次找到kth smallest element就行
        while (k-- > 0) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;
            // 每次poll一个element出来
            res = matrix[i][j];

            for (int[] dir : DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && !visited[ii][jj]) {
                    queue.offer(ii * col + jj);
                    visited[ii][jj] = true;
                }
            }
        }
        return res;
    }
}

// time O(k*log(min(m+n, k)));
// space: heap O(min(m+n, k)) + visited O(m*n) [visited可以使用set优化成O(k)]
