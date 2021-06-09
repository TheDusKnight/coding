package leetcode._0097_InterleavingString;

class Solution {
    // dp 双指针滑动
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if (s1.length() + s2.length() != s3.length())
            return false;
        
        int len1 = s1.length(), len2 = s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = s2.substring(0,j).equals(s3.substring(0,j));
        }
        
        for (int i = 0; i < len1; i++) { // 注意这里的index是string的index, dp要加1
            for (int j = 0; j < len2; j++) {
                int k = i+j+1;
                // if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
                //     dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                // } else if (s1.charAt(i) == s3.charAt(k)) {
                //     dp[i+1][j+1] = dp[i][j+1];
                // } else if (s2.charAt(j) == s3.charAt(k)) {
                //     dp[i+1][j+1] = dp[i+1][j];
                // } else {
                //     dp[i+1][j+1] = false;
                // }
                if (s1.charAt(i) == s3.charAt(k)) { // 优化写法
                    dp[i+1][j+1] = dp[i][j+1];
                }
                if (s2.charAt(j) == s3.charAt(k)) {
                    dp[i+1][j+1] = dp[i+1][j+1] || dp[i+1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}
