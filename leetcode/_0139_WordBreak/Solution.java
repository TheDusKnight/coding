package leetcode._0139_WordBreak;
import java.util.*;

// TODO: dfs
// 二维dp -> 一维dp -> list of index 只保留历史上index是true的情况
// 这是一维dp解法
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // cc

        Set<String> set = new HashSet<>();
        for (String word: wordDict) {
            set.add(word);
        }

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        // first i letters [0, i)
        for (int i = 1; i <= len; i++) {
            // 左边看dp有没有，右边看是否dict contains
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}

// time: n^2 * n = O(n^s) because substring is O(n)