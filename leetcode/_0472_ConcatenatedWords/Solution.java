package leetcode._0472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs + pruning. 时间长
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        if (words.length == 1) return res;
        
        Set<String> set = new HashSet<>();
        for (String word: words) {
            set.add(word);
        }
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) // 不计算空string
                continue;
            Boolean[] memo = new Boolean[words[i].length()];
            set.remove(words[i]); // 先去掉自己
            if (dfs(words[i], set, 0, memo)) {
                res.add(words[i]);
            }
            set.add(words[i]); // 加回自己
        }
        return res;
    }
    
    private boolean dfs(String word, Set<String> words, int idx, Boolean[] memo) {
        if (idx == word.length())
            return true;
        if (memo[idx] != null)
            return memo[idx];
        
        for (int i = idx; i < word.length(); i++) {
            String sub = word.substring(idx, i+1);
            if (words.contains(sub) && dfs(word, words, i+1, memo)) {
                memo[idx] = true;
                return true;
            }
        }
        memo[idx] = false;
        return false;
    }
}

// time: O(n * k^2). k is the average length of each word, n is the number of words