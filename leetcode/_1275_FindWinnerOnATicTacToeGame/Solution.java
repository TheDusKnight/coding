package leetcode._1275_FindWinnerOnATicTacToeGame;

// ood
class Solution {
    private static final int N = 3;
    public String tictactoe(int[][] moves) {
        // cc
        
        int n = moves.length;
        int[] rows = new int[N], cols = new int[N];
        int diag = 0, anti = 0, player = 1, win = N;
        
        for (int[] move: moves) {
            int x = move[0], y = move[1];
            rows[x] += player;
            cols[y] += player;
            if (x == y) diag += player;
            if (x+y == N-1) anti += player;
            
            if (rows[x] == win || cols[y] == win || diag == win || anti == win)
                return player == 1 ? "A" : "B";
            player = -player;
            win = -win;
        }
        
        if (n == N*N) return "Draw";
        return "Pending";
    }
}

// time: O(n);