package leetcode._0079_WordSearch;

// 算法哥dfs, 需要考虑成环情况
class Solution {
    // private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    // private boolean[][] visited = new boolean[board.length][board[0].length];
    
    public boolean exist(char[][] board, String word) {
        // cc
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        if (word == null || word.length() == 0) return false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0, visited)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        // leave node 挂着个null情况return true
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }
        
        visited[i][j] = true; // The same letter cell may not be used more than once.
        boolean res = dfs(board, word, i+1, j, index+1, visited) || dfs(board, word, i-1, j, index+1, visited) || dfs(board, word, i, j+1, index+1, visited) || dfs(board, word, i, j-1, index+1, visited);
        visited[i][j] = false;
        return res;
    }
}

// time: O(m*n*min(m*n, 4^k)) k is the length of word
// space: O(min(m*n, k) + O(m*n)) = O(m*n + k)