package leetcode._0140_WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
    // dfs + 特殊方法pruning
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return res;
        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }
        boolean[] visited = new boolean[s.length()];
        Arrays.fill(visited, true);
        dfs(res, s, 0, new StringBuilder(), set, visited);
        return res;
    }
    
    private void dfs(List<String> res, String s, int idx, StringBuilder path, Set<String> wordDict, boolean[] visited) {
        int tLen = s.length();
        int pLen = path.length();
        if (idx == tLen) {
            res.add(path.toString().trim());
            return;
        }
        if (!visited[idx]) // 只能在走不通的情况下节省时间，走得通的情况还要全套大保健一遍
            return;
        
        int curSize = res.size(); // cache res长度
        for (int i = idx; i < tLen; i++) {
            String cur = s.substring(idx, i+1);
            if (wordDict.contains(cur)) {
                path.append(cur + " ");
                dfs(res, s, i+1, path, wordDict, visited);
                path.setLength(pLen);
            }
        }
        if (curSize == res.size()) // 如果长度没变，说明走不通，以后就不要走了
            visited[idx] = false;
    }
}
// time: O(2^n) pruning常数级别优化
