package leetcode._0062_UniquePaths;

import java.util.Arrays;

// 一维dp最优解
class Solution4 {
    public int uniquePaths(int m, int n) {
        // cc
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        
        return dp[0];
    }
}

// time: O(m*n); space: O(n);
