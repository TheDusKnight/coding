package leetcode._0139_WordBreak;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 二维dp -> 一维dp -> list of index 只保留历史上index是true的情况
public class Solution3 {
    // 老刘一维dp从左到右
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

    // 算法哥一维dp
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;
        HashSet<String> set = new HashSet<>();
        int tLen = s.length();
        for (String word: wordDict) {
            set.add(word);
        }
        boolean dp[] = new boolean[tLen+1];
        dp[tLen] = true; // j走到头为true
        for (int i = tLen-1; i >= 0; i--) {
            for (int j = i; j < tLen; j++) {
                String str = s.substring(i, j+1);
                // 当i到j的substring valid，判断j后面一位是否也valid
                if (set.contains(str) && dp[j+1]) {
                    dp[i] = true;
                    // 一通百通
                    break;
                }
            }
        }
        return dp[0];
    }
}

// time: n^2 * n = O(n^s) because substring is O(n), 言之有理即可