package leetcode._0378_KthSmallestElementInASortedMatrix;
import java.util.*;

// bfs + min-heap
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

// time O(k*log(k))
// space: O(k) heap + O(n*m) boolean 2d array || O(k) heap + min(m+n-1, k) hashset查重
