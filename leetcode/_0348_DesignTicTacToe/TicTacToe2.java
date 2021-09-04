package leetcode._0348_DesignTicTacToe;

class TicTacToe2 {
    int[] rows;
    int[] cols;
    int diag;
    int anti;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe2(int n) {
        rows = new int[n];
        cols = new int[n];
        diag = 0;
        anti = 0;
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
        int move = player == 1 ? -1 : 1;
        rows[row] += move;
        cols[col] += move;
        if (row == col) diag += move;
        if (row == n-1-col) anti += move;
        
        if (player == 2 && (rows[row] == n || cols[col] == n || diag == n || anti == n)) return 2;
        else if (player == 1 && (rows[row] == -n || cols[col] == -n || diag == -n || anti == -n)) return 1;
        else return 0;
    }
}

// time: O(1); space: O(N);
