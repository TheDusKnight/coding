package leetcode._0472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs + pruning similar to word break
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length <= 1) return res;
        
        Set<String> dict = new HashSet<>();
        Arrays.sort(words, (o1, o2) -> (o1.length() - o2.length()));
        
        for (String word: words) {
            Boolean[] memo = new Boolean[word.length()];
            if (dfs(dict, word, memo, 0)) {
                res.add(word);
            }
            dict.add(word);
        }
        
        return res;
    }
    
    private boolean dfs(Set<String> dict, String word, Boolean[] memo, int idx) {
        if (idx == word.length()) {
            return !word.isEmpty(); // 注意判断word是否是empty
        }
        if (memo[idx] != null) return memo[idx];
        
        for (int i = idx; i < word.length(); i++) {
            String substring = word.substring(idx, i+1);
            if (dict.contains(substring) && dfs(dict, word, memo, i+1)) {
                memo[idx] = true;
                return memo[idx];
            }
        }
        memo[idx] = false;
        return memo[idx];
    }
}

// time: O(n *L^2); n is the number of words, L is the average length of each word. pruning memo length * size = L^2; space: O(n * L);