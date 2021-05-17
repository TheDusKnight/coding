package jianzhioffer.recursionDp._10;

// 一维dp
public class Solution2 {
    public int fib(int n) {
        int[] dp = new int[101];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.fib(100));
    }
}
