package leetcode;

class Solution {
    int row, col;
    public boolean exist(char[][] board, String word) {
        // cc
        row = board.length; col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int idx, int i, int j) {
        if (idx == word.length() - 1)
            return true;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || idx >= word.length() || board[i][j] != word.charAt(idx))
            return false;
        
        visited[i][j] = true;
        boolean res = dfs(board, visited, word, idx+1, i+1, j) || dfs(board, visited, word, idx+1, i-1, j) || dfs(board, visited, word, idx+1, i, j+1) || dfs(board, visited, word, idx+1, i, j-1);
        visited[i][j] = false;
        return res;
    }
}

