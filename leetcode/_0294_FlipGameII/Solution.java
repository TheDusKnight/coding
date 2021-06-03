package leetcode._0294_FlipGameII;

public class Solution {
    // dfs无pruning
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() == 0)
            return false;
        return dfs(currentState.toCharArray());
    }

    private boolean dfs(char[] board) {
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i] == '+' && board[i + 1] == '+') {
                board[i] = '-';
                board[i + 1] = '-';
                if (!dfs(board)) {
                    board[i] = '+';
                    board[i + 1] = '+';
                    return true;
                }
                board[i] = '+';
                board[i + 1] = '+';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canWin("++++"));
    }
}

// time: O(n^n);
