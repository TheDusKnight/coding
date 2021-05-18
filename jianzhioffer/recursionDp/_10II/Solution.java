package jianzhioffer.recursionDp._10II;

/**
 * 青蛙跳台阶问题
 */

// 一维dp
public class Solution {
    public int numWays(int n) {
        if (n <=1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}
