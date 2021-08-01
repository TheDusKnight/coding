package leetcode._0909_SnakesAndLadders;

import java.util.LinkedList;
import java.util.Queue;

// bfs
public class Solution{
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        int move = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int num = queue.poll();
                if (visited[num]) {
                    // System.out.println(num);
                    continue;
                }
                visited[num] = true;
                if (num == n * n) return move;
                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
                    int next = num + i;
                    int value = getBoardValue(board, next);
                    if (value > 0) next = value;
                    if (!visited[next]) queue.offer(next);
                }
            }
            move++;
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        int n = board.length;
        int oldRow = (num - 1) / n;
        int row = n-1 -oldRow;
        int oldCol = (num-1) % n;
        int col = oldRow % 2 == 0 ? oldCol : n - 1 - oldCol;
        
        return board[row][col];
    }
}