package leetcode._0052_NQueensII;

// 记录一下global count就行，不用输出board
public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) return -1;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        dfs(board, n, 0);
        return count;
    }

    private void dfs(char[][] board, int n, int colIndex) {
        if (colIndex == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, n, colIndex+1);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x == i || Math.abs(i-x) == Math.abs(j-y)))
                    return false;
            }
        }
        return true;
    }
}
