package leetcode._0161_OneEditDistance;

// 匹配问题
// dp，照抄LC72 edit distance 检查结果是否为1
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        // cc
        if (s == null || t == null) return false;
        if (s.length() == 0 && t.length() == 0) return false;
        if (s.length() == 0 && t.length() == 1) return true;
        if (s.length() == 1 && t.length() == 0) return true;

        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i= 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // i，j从1开始，所以word从i-1，j-1开始
                if ((s.charAt(i-1) == t.charAt(j-1))) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        return dp[m][n] == 1 ? true : false;
    }
}