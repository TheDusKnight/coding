package leetcode._0472_ConcatenatedWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dp做法。要点：先从小到大sort一遍，每次做完一个小的word把它放到set里作为下一次concatenated word的可能组成，用dp check当前word是否是concatenated
class Solution2 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, (s1, s2) -> (s1.length() - s2.length()));
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(preWords, words[i])) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }
        return res;
    }
    
    private boolean canForm(Set<String> preWords, String word) {
        if (preWords.size() == 0) // 如果没有比当前word更小的string，那么返回false
            return false;
        
        int len = word.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                String sub = word.substring(i, j+1);
                if (preWords.contains(sub) && dp[j+1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}

// time: O(L^3 * N). L is the average length of a word, N is the number of words