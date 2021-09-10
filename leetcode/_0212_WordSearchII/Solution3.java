package leetcode._0212_WordSearchII;

import java.util.ArrayList;
import java.util.List;

// build trie + recursion search trie
// can be improved, read leetcode solution
class TrieNode {
    char ch;
    boolean isLeaf;
    TrieNode[] nexts;
    
    public TrieNode(char ch) {
        this.ch = ch;
        nexts = new TrieNode[26];
    }
}

class Solution3 {
    char[][] board;
    String[] words;
    boolean[][] visited;
    int row, col;
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        // cc
        
        this.board = board;
        this.words = words;
        row = board.length;
        col = board[0].length;
        visited = new boolean[row][col];
        
        TrieNode root = buildTrie(words);
        
        res = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(root, i, j, new StringBuilder());
            }
        }
        
        return res;
    }
    
    private void dfs(TrieNode cur, int i, int j, StringBuilder sb) {
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || cur.nexts[board[i][j] - 'a'] == null) return;
        
        TrieNode next = cur.nexts[board[i][j] - 'a'];
        int len = sb.length();
        sb.append(next.ch);
        visited[i][j] = true;
        
        if (next.isLeaf) {
            res.add(sb.toString());
            next.isLeaf = false;
        }
        
        dfs(next, i+1, j, sb); dfs(next, i-1, j, sb); dfs(next, i, j+1, sb); dfs(next, i, j-1, sb);
        
        sb.setLength(len);
        visited[i][j] = false;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode('\0');
        for (String w: words) {
            TrieNode cur = root;
            for (char c: w.toCharArray()) {
                if (cur.nexts[c - 'a'] == null) cur.nexts[c - 'a'] = new TrieNode(c);
                cur = cur.nexts[c - 'a'];
            }
            cur.isLeaf = true;
        }
        
        return root;
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = new String[] {"oath", "oathk", "pea", "eat", "rain"};
        Solution3 sol = new Solution3();
        System.out.println(sol.findWords(board, words).toString());
    }
}


