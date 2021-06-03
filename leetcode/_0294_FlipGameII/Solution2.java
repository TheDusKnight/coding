package leetcode._0294_FlipGameII;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    // dfs + pruning
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() == 0)
            return false;
        Map<String, Boolean> memo = new HashMap<>();
        return dfs(currentState.toCharArray(), memo);
    }

    private boolean dfs(char[] board, Map<String, Boolean> memo) {
        Boolean flag = memo.get(String.valueOf(board));
        if (flag != null)
            return flag;
        for (int i = 0; i < board.length - 1; i++) {
            if (board[i] == '+' && board[i + 1] == '+') {
                board[i] = '-';
                board[i + 1] = '-';
                if (!dfs(board, memo)) {
                    board[i] = '+';
                    board[i + 1] = '+';
                    memo.put(String.valueOf(board), true);
                    return true;
                }
                board[i] = '+';
                board[i + 1] = '+';
            }
        }
        memo.put(String.valueOf(board), false);
        return false;
    }
}

// time: O(2^n*n) = O(2*n);
