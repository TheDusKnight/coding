package leetcode._0005_LongestPalindromicSubstring;

// DP
// https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
class Solution {
    public String longestPalindrome(String s) {
        // cc
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = null;
        
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1]);
                
                if (dp[i][j] && (res == null || j-i+1 > res.length())) {
                    res = s.substring(i, j+1);
                }
            }
        }
        
        return res;
    }
}

// time: O(n^2); space: O(n^2);