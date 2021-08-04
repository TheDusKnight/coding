package leetcode._0139_WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 返回任意一条路径
class WordBreakIII {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }
        Map<Integer, Integer> path = new HashMap<>();
        Boolean[] memo = new Boolean[s.length()];
        boolean res = dfs(s, 0, set, path, memo);
        List<String> one = recoverPath(path, s);
        System.out.println(one.toString());
        return res;
    }
    
    private boolean dfs(String s, int idx, Set<String> wordDict, Map<Integer, Integer> path, Boolean[] memo) {
        int len = s.length();
        if (idx == len) {
            return true;
        }
        if (memo[idx] != null)
            return memo[idx];
        
        for (int i = idx; i < len; i++) {
            String cur = s.substring(idx, i+1);
            if (wordDict.contains(cur) && dfs(s, i+1, wordDict, path, memo)) {
                path.put(i, idx);
                memo[idx] = true;
                return true;
            }
        }
        memo[idx] = false;
        return false;
    }
    // 正着搜，反着存
    private List<String> recoverPath(Map<Integer, Integer> path, String s) {
        int end = s.length()-1;
        int start;
        List<String> one = new ArrayList<>();
        while (end != -1) {
            start = path.get(end);
            one.add(0, s.substring(start, end+1));
            end = start-1;
        }
        return one;
    }

    public static void main(String[] args) {
        WordBreakIII sol = new WordBreakIII();
        // System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet", "code")));
        // System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(sol.wordBreak("catsanddog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
