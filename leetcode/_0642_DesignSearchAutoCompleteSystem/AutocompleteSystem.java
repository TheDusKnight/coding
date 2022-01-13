package leetcode._0642_DesignSearchAutoCompleteSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 实际面试中getTop3(), updateTop3()可能就不用写了，因为考察Trie操作
class TrieNode {
    char ch;
    TrieNode[] children;
    List<Pair> top3;
    boolean isWord;
    
    public TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[27];
        top3 = new ArrayList<>();
        isWord = false;
    }
    
    public List<String> getTop3() {
        List<String> res = new ArrayList<>();
        for (Pair p: this.top3) {
            res.add(p.str);
        }
        return res;
    }
    
    public void updateTop3(String str, int time) {
        int i = 0;
        for (i = 0; i < top3.size(); i++) {
            Pair p = top3.get(i);
            if (p.str.equals(str)) {
                p.time = time;
                break;
            }
        }
        if (i == top3.size()) { // insert
            top3.add(new Pair(str, time));
        }
        // Collections.sort(top3, (p1, p2) -> { // update
        //     p1.time == p2.time ? p1.str.compareTo(p2.str) : p2.time - p1.time;
        // });

        Collections.sort(top3, (p1, p2) -> { // update; 为什么这里不能用三目运算？
            if (p1.time == p2.time) {
                return p1.str.compareTo(p2.str);
            }
            return p2.time - p1.time;
        });

        List<Pair> list = new ArrayList<>();
        for (int j = 0; j < Math.min(3, top3.size()); j++) {
            list.add(top3.get(j));
        }
        this.top3 = list;
    }
}

class Pair {
    String str;
    int time;
    
    public Pair(String str, int count) {
        this.str = str;
        this.time = count;
    }
}

public class AutocompleteSystem {
    TrieNode root;
    TrieNode cur;
    HashMap<String, Integer> count;
    StringBuilder sb;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode('\0');
        count = new HashMap<>();
        sb = new StringBuilder(); // for '#' insert string
        cur = root; // cur每次search从上一次的TrieNode开始
        
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
            count.put(sentences[i], times[i]);
        }
        cur = root;
    }
    
    public List<String> input(char ch) {
        if (ch == '#') {
            String s = sb.toString();
            sb.setLength(0); // 将sb恢复为0，准备下一次append
            Integer co = count.getOrDefault(s, 0);
            count.put(s, co+1);
            insert(s, co+1);
            cur = root; // 将cur重置为root
            return new ArrayList<>();
        }
        sb.append(ch);
        // 有可能之前cur就是null需要check一下
        if(cur == null) { return new ArrayList<>(); }
        cur = cur.children[getIndex(ch)];
        if (cur == null) { return new ArrayList<>(); }
        return cur.getTop3();
    }
    
    private void insert(String str, int time) {
        cur = root;
        for (char ch: str.toCharArray()) {
            int idx = getIndex(ch);
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode(ch);
            }
            cur = cur.children[idx];
            cur.updateTop3(str, time);
        }
        cur.isWord = true;
    }
    
    private int getIndex(char ch) {
        return (ch >= 'a' && ch <= 'z') ? (ch-'a') : 26;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */