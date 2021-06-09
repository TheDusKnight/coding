package leetcode._0115_DistinctSubsequences;

public class Solution {
    // dp 双指针滑动
    public int numDistinct(String s, String t) {
        if (s == null || t == null)
            return -1;
        
        int lenS = s.length(), lenT = t.length();
        int[][] dp = new int[lenS+1][lenT+1];
        // 注意初始化循序，dp[0][0]必须初始化为1
        for (int j = 0; j <= lenT; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= lenS; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < lenS; i++) { // 注意这里的index是string的index, dp要加1
            for (int j = 0; j < lenT; j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                }
            }
        }
        return dp[lenS][lenT];
    }
}

// time: O(n^2)
