package leetcode._0264_UglyNumberII;

// 一维dp
class Solution {
    public int nthUglyNumber(int n) {
        // cc
        if (n <= 0) throw new IllegalArgumentException();
        
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int[] dp = new int[n]; // dp[i]指第i-1个丑数
        dp[0] = 1; // 第一个丑数是1
        
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[idx2] * 2, Math.min(dp[idx3] * 3, dp[idx5] * 5)); // 下一个赋值的是最小的丑数
            if (dp[i] == dp[idx2] * 2)
                idx2++;
            if (dp[i] == dp[idx3] * 3)
                idx3++;
            if (dp[i] == dp[idx5] * 5)
                idx5++;
        }
        
        return dp[n-1];
    }
}

// time: O(N); space: O(N);