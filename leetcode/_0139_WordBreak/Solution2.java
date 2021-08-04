package leetcode._0139_WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 自写dfs pruning
// 注意和word search的比较，word search中的visited check出环，而word break的memo check入度大于1
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }
        Boolean[] memo = new Boolean[s.length()];
        return dfs(s, set, 0, memo);
    }
    
    private boolean dfs(String s, Set<String> wordDict, int idx, Boolean[] memo) {
        int sLen = s.length();
        if (idx >= sLen)
            return true;
        if (memo[idx] != null)
            return memo[idx]; // 可以直接return false因为memo记录true之后直接一路返回true
        
        for (int i = idx; i < sLen; i++) {
            String cur = s.substring(idx, i+1);
            if (wordDict.contains(cur) && dfs(s, wordDict, i+1, memo)) {
                memo[idx] = true;
                return true;
            }
        }
        memo[idx] = false;
        return false;
    }
}

// time: O(n^2), (memo list length) * (time to calc one value in list, 在这道题就是计算一层dfs所需要的时间)
// 个人认为优化的原因是call dfs的次数降为n