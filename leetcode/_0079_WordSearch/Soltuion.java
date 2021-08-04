package leetcode._0079_WordSearch;

class Solution {
    // dfs 2d board search problem
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, visited, i, j))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int idx, boolean[][] visited, int i, int j) {
        if (idx == word.length()) // 当idx == word.length()-1时依然需要check最后一个元素是否相等
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx) || visited[i][j])
            return false;
        
        visited[i][j] = true; // 考虑成环
        boolean ret = dfs(board, word, idx+1, visited, i+1, j) || dfs(board, word, idx+1, visited, i-1, j)
         || dfs(board, word, idx+1, visited, i, j+1) || dfs(board, word, idx+1, visited, i, j-1);
        visited[i][j] = false; // 无论path是否valid，都要在弹栈后将当前vertex visited还原
        return ret;
    }
}

// 该题不能用pruning，因为没有重复计算，每次for loop dfs的path都是唯一的
// time: O(n*m*4^L); space: O(n*m) visited的size (不计算栈的情况下)。n*m为2d board长和宽，L为word长度

// 另一种计算方法，考虑word有可能比2d board长的情况
// L is the length of word
// space: O(min(m*n, L) + O(m*n)) = O(m*n + L) // 栈的深度加visited的size