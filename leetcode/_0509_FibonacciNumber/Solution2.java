package leetcode._0509_FibonacciNumber;

// dp 空间优化做法
class Solution2 {
    public int fib(int N) {
        // cc
        if (N < 0) throw new IllegalArgumentException();
        if (N <= 1) return N;
        return memoize(N);
    }
    
    private int memoize(int N) {
        int dp0 = 0, dp1 = 1, dp = 2;
        for (int i = 2; i <= N; i++) {
            dp = dp0 + dp1;
            int tmp = dp1;
            dp1 = dp;
            dp0 = tmp;
        }
        return dp;
    }
}
// time: O(N);
// space: O(1);
