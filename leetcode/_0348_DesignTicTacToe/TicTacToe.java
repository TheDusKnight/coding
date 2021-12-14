package leetcode._0348_DesignTicTacToe;

// ood
class TicTacToe {
    int[] rows, cols;
    int diag, antiDiag;
    int n;
    public TicTacToe(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diag = 0; antiDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        int stone = player == 1 ? 1 : -1;
        int win = player == 1 ? n : -n;
        rows[row] += stone;
        cols[col] += stone;
        if (row == col) diag += stone;
        if (row+col == n-1) antiDiag += stone;
        
        if (diag == win || antiDiag == win || rows[row] == win || cols[col] == win) return player;
        return 0;
    }
}
// time: O(1); space: O(N);

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
