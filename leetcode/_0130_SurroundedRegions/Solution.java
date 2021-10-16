package leetcode._0130_SurroundedRegions;
import java.util.LinkedList;
import java.util.Queue;

// BFS/DFS
class Solution {
    int row, col;
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    Queue<Integer> queue = new LinkedList<>();
    public void solve(char[][] board) {
        // cc
        
        row = board.length;
        col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || i == row-1 || j == col-1) && board[i][j] == 'O') {
                    // bfs(board, i, j);
                    dfs(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
        
    }
    
    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O') {
            return;
        }
        
        board[r][c] = 'Y';
        for (int[] dir: DIRECTIONS) dfs(board, r+dir[0], c+dir[1]);
    }
    
    // private void bfs(char[][] board, int r, int c) {
    //     board[r][c] = 'Y';
    //     queue.offer(r * col + c);
        
    //     while (!queue.isEmpty()) {
    //         int cur = queue.poll();
    //         int i = cur / col;
    //         int j = cur % col;
            
    //         for (int[] dir: DIRECTIONS) {
    //             int ii = i + dir[0];
    //             int jj = j + dir[1];
                
    //             if (ii >= 0 && ii < row && jj >= 0 && jj < col && board[ii][jj] == 'O') {
    //                 board[ii][jj] = 'Y';
    //                 queue.offer(ii * col + jj);
    //             }
    //         }
    //     }
    // }
}

// time: O(m*n); space: O(m*n);
