package leetcode._0211_DesignAddAndSearchWordsDataStructure;
// Trie
class TrieNode {
    char ch;
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[26];
    }
}

public class WordDictionary {
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('\0');
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch: word.toCharArray()) {
            // 将char强制转换成int
            if (cur.children[ch-'a'] == null) {
                cur.children[ch-'a'] = new TrieNode(ch);
            }
            cur = cur.children[ch-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }
    
    // 通过dfs找到当char为'.‘存在的all possible solutions
    private boolean dfs(String word, TrieNode root, int idx) {
        if (root == null) return false;
        // idx和word因为dummy root的原因错位，idx指向word的最后一个char
        // 当前层trie node的含义是上一层的idx字母
        if (idx == word.length()) {
            return root.isWord;
        }
        
        char cur = word.charAt(idx);
        if (cur != '.') {
            return dfs(word, root.children[cur-'a'], idx+1);
        }
        for (TrieNode child: root.children) {
            if (dfs(word, child, idx+1)) return true;
        }
        return false;
    }
}

// time: O(N*26^M) N is number of search, M is word average length

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
