package leetcode._0212_WordSearchII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs + set 时间复杂度高
public class Solution {
    int row, col;
    public List<String> findWords(char[][] board, String[] words) {
        // cc
        row = board.length; col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                for (String word: words) {
                    if (dfs(board, word, 0, visited, i, j))
                        set.add(word);
                }
            }
        }
        res.addAll(set);
        return res;
    }

    private boolean dfs(char[][] board, String word, int idx, boolean[][] visited, int i, int j) {
        if (idx == word.length())
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

// time: O(n*m*l*4^L)。n，m是matrix的长和宽，l是word list的长度，L是word的平均长度; space: O(n*m);
