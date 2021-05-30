package leetcode._0139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // 自写dfs无剪枝
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        Set<String> set = new HashSet<String>();
        for (String word: wordDict) {
            set.add(word);
        }
        return dfs(s, set, 0);
    }
    
    private boolean dfs(String s, Set<String> wordDict, int idx) {
        int tLen = s.length();
        if (idx == tLen)
            return true;
        
        for (int i = idx; i < tLen; i++) {
            String cur = s.substring(idx, i+1);
            // 一通百通逻辑
            if (wordDict.contains(cur) && dfs(s, wordDict, i+1)) {
                return true;
            }
        }
        return false;
    }
}

// time: O(2^n); space: O(n)