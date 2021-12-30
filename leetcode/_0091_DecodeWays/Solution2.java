package leetcode._0091_DecodeWays;

// dp best solution
class Solution2 {
    public int numDecodings(String s) {
        // cc
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) return 0;
        
        int len = s.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != '0') dp[i+1] += dp[i];
            int two = Integer.valueOf(s.substring(i-1, i+1));
            if (two >= 10 && two <= 26) dp[i+1] += dp[i-1];
        }
        
        return dp[len];
    }
}
// time: O(n)
// space: O(n)