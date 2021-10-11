package leetcode._0212_WordSearchII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// dfs + trie
class TrieNode {
    Map<Character, TrieNode> children;
    String word;
    char ch;
    
    public TrieNode(char ch) {
        this.ch = ch;
        word = null;
        children = new HashMap<>();
    }
}

class Solution3 {
    TrieNode root;
    char[][] board;
    int row, col;
    boolean[][] visited;
    List<String> res;
    private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        // cc
        this.board = board;
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        res = new ArrayList<>();
        
        root = new TrieNode('\0');
        TrieNode cur;
        for (String word: words) {
            cur = root;
            for (char ch: word.toCharArray()) {
                TrieNode next = cur.children.get(ch);
                if (next == null) cur.children.put(ch, new TrieNode(ch));
                cur = cur.children.get(ch);
            }
            cur.word = word;
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(i, j, root);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(int i, int j, TrieNode parent) {
        // 失败的base case
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || parent.children.get(board[i][j]) == null) {
            return;
        }
        // 成功的base case
        TrieNode cur = parent.children.get(board[i][j]);
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        // remove if leave node and return
        if (cur.children.isEmpty()) {
            parent.children.remove(board[i][j]);
            return;
        }
        
        visited[i][j] = true;
        for (int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            dfs(ii, jj, cur);
        }
        visited[i][j] = false;
    }
}

// time: O(n*m*4^L); space: O(N) N is the total number of letters in dictionary;