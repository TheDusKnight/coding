package leetcode._0139_WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// 问题：最少cut几刀？
public class Followup {
    // 将boolean[]改成int[]
    // dp解法
    public int wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return -1;
        HashSet<String> set = new HashSet<>();
        int tLen = s.length();
        for (String word: wordDict) {
            set.add(word);
        }
        int dp[] = new int[tLen+1]; // 可以改成Integer[]初始为null说明没走过
        Arrays.fill(dp, -2);
        // 根据面试官要求分析切一刀值为多少？
        dp[tLen] = -1;
        for (int i = tLen-1; i >= 0; i--) {
            for (int j = i; j < tLen; j++) {
                String str = s.substring(i, j+1);
                // 当i到j的substring valid，判断j后面一位是否也valid
                if (set.contains(str) && dp[j+1] > -2) {
                    dp[i] = dp[i] == -2 ? dp[j+1]+1 : Math.min(dp[j+1]+1, dp[i]);
                    // 不断更新，不是一通百通，不能加break
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Followup sol = new Followup();
        List<String> wordDict = new ArrayList<String>(Arrays.asList("cat", "sand", "dog", "catsand"));
        System.out.println(sol.wordBreak("catsanddog", wordDict));
    }
}

// time: O(n^3)
