package leetcode._0212_WordSearchII;

import java.util.ArrayList;
import java.util.List;

// 自写dfs提前返回
class Solution2 {
    char[][] board;
    String[] words;
    boolean[][] visited;
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        visited = new boolean[board.length][board[0].length];
        res = new ArrayList<>();
        boolean flag = false;
        
        for (String word: words) {
            flag = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(0, i, j, word)) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) break;
            }
        }

        return res;
    }
    
    private boolean dfs(int idx, int i, int j, String word) {
        if (idx == word.length()) {
            res.add(word);
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(idx) != board[i][j] || visited[i][j])
            return false;
        
        visited[i][j] = true;
        boolean res = dfs(idx+1, i+1, j, word) || dfs(idx+1, i-1, j, word) || dfs(idx+1, i, j+1, word) || dfs(idx+1, i, j-1, word);
        visited[i][j] = false;
        return res;
    }
}

// time: O(m*n*words*4^L)
