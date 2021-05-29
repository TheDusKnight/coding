package leetcode._0140_WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    // dfs 自写无boolean array速度快
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return res;
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }
        dfs(res, s, set, new StringBuilder(), 0);
        return res;
    }

    private void dfs(List<String> res, String s, Set<String> wordDict, StringBuilder path, int idx) {
        int tLen = s.length();
        int pLen = path.length();
        if (idx == tLen) {
            res.add(path.toString().trim());
            return;
        }

        for (int i = idx; i < tLen; i++) {
            String cur = s.substring(idx, i+1);
            if (wordDict.contains(cur)) {
                // if (idx == 0) {
                //     path.append(cur);
                //     dfs(res, s, wordDict, path, i+1);
                //     path.setLength(pLen);
                // } else {
                //     path.append(" " + cur);
                //     dfs(res, s, wordDict, path, i+1);
                //     path.setLength(pLen);
                // }

                path.append(cur + " ");
                dfs(res, s, wordDict, path, i+1);
                path.setLength(pLen);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }
}

// time: O(2^n), space: O(3*n)
