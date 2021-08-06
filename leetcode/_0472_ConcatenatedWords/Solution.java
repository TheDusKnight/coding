package leetcode._0472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // cc
        
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word: words)
            set.add(word);
        for (int i = 0; i < words.length; i++) {
            if (dfs(words[i], set, 0)) {
                res.add(words[i]);
            }
        }
        return res;
    }
    
    private boolean dfs(String word, Set<String> words, int idx) {
        if (idx == word.length())
            return true;
        
        for (int i = idx; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                String sub = word.substring(i, j+1);
                if (word.contains(sub) && dfs(word, words, j+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
