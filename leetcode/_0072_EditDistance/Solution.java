package leetcode._0072_EditDistance;

// 匹配问题
// 二维dp
class Solution {
    public int minDistance(String word1, String word2) {
        // cc
        if (word1 == null || word2 == null) return -1;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int m = word1.length();
        int n = word2.length();
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
                if ((word1.charAt(i-1) == word2.charAt(j-1))) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}

// time: m * n