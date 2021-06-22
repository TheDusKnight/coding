package leetcode._0208_ImplementTrie_PrefixTree;

class TrieNode {
    char ch;
    boolean isWord;
    TrieNode[] children;
    
    public TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) { // O(k)
        // cc
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) { // O(k)
        // cc
        TrieNode cur = helper(word);
        if (cur == null) return false;
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) { // O(k)
        // cc
        TrieNode cur = helper(prefix);
        if (cur == null) return false;
        return true;
    }
    
    private TrieNode helper(String s) {
        TrieNode cur = root;
        for (char ch: s.toCharArray()) {
            TrieNode next = cur.children[ch-'a'];
            if (next == null) { return null; }
            cur = next;
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
