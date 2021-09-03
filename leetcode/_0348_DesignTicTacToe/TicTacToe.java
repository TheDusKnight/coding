package leetcode._0348_DesignTicTacToe;

// Brute Force
class TicTacToe {
    int[][] board;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkCol(col, player) || checkRow(row, player) || checkDiag(player) || checkAnti(player))
            return player;
        return 0;
    }
    
    private boolean checkCol(int col, int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != player)
                return false;
        }
        return true;
    }
    
    private boolean checkRow(int row, int player) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player)
                return false;
        }
        return true;
    }
    
    private boolean checkDiag(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != player)
                return false;
        }
        return true;
    }
    
    private boolean checkAnti(int player) {
        for (int i = 0; i < n; i++) {
            if (board[i][n-1-i] != player)
                return false;
        }
        return true;
    }
}

// time: O(n); space: O(n^2);

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
