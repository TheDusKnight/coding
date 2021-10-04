package leetcode._0072_EditDistance;

// 一维dp
class Solution3 {
    public int minDistance(String word1, String word2) {
        // cc
        
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n+1];
        for (int j = 0; j <= n; j++) dp[j] = j;
        int pre;
        int cur = 1; // 注意初始化取值
        
        for (int i = 1; i <= m; i++) { // i, j代表长度
            pre = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    cur = dp[j-1];
                } else {
                    cur = Math.min(pre, Math.min(dp[j-1], dp[j])) + 1;
                }
                dp[j-1] = pre;
                pre = cur;
            }
            dp[n] = cur;
        }
        
        return dp[n];
    }
}

// time: O(m*n); space: O(Math.min(m, n));
