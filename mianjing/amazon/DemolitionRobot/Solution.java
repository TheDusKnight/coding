package mianjing.amazon.DemolitionRobot;

import java.util.LinkedList;
import java.util.Queue;

// BFS
public class Solution {
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static int demolitionRobot(int[][] matrix) {
        // cc

        int row = matrix.length, col = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int minLen = 0;
        boolean[][] visited = new boolean[row][col];

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                if (matrix[i][j] == 9) {
                    return minLen;
                }

                for (int[] dir: DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && !visited[ii][jj] && matrix[ii][jj] != 0) {
                        visited[ii][jj] = true;
                        queue.offer(ii * col + jj);
                    }
                }
            }
            minLen++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,0}, {0,1,0}, {9,1,0}};
        System.out.println(Solution.demolitionRobot(matrix));
    }
}

// time: O(m*n);
