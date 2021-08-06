package leetcode._0051_NQueens;
import java.util.ArrayList;
import java.util.List;

// 如果你用array不需要回溯因为是赋值操作
// recursion
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        // board初始化成'.''
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        dfs(board, res, n, 0);
        return res;
    }
    
    private void dfs(char[][] board, List<List<String>> res, int n, int colIndex) {
        if (colIndex == n) {
            res.add(convertMatrix(board));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (isValid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, res, n, colIndex+1);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            // column从小变大，所以check isValid的时候只需要check小于当前col idx即可
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x == i || Math.abs(i-x) == Math.abs(j-y)))
                    return false;
            }
        }
        return true;
    }
    
    // 把2d matrix压扁
    private List<String> convertMatrix(char[][] board) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            tmp.add(new String(board[i]));
            // 不要使用下面这个方法因为会print中括号[]!!
            // tmp.add(Arrays.toString(board[i]));
        }
        return tmp;
    }
}

// time: 一个棋子n种选择，第二个n-1，直到1。O(n!); space: O(n^2);