package leetcode._0062_UniquePaths;

import java.util.Arrays;

// 二维dp
class Solution3 {
    // public int uniquePaths(int m, int n) {
    //     // cc
        
    //     int[][] dp = new int[m][n];
    //     for (int i = m-1; i >= 0; i--) {
    //         for (int j = n-1; j >= 0; j--) {
    //             if (i == m-1 && j == n-1) {
    //                 dp[i][j] = 1;
    //                 continue;
    //             }
    //             int right = j + 1 > n-1 ? 0 : dp[i][j+1];
    //             int down = i + 1 > m-1 ? 0 : dp[i+1][j];
    //             dp[i][j] = right + down;
    //         }
    //     }
        
    //     return dp[0][0];
    // }

    public int uniquePaths(int m, int n) {
        // cc
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1);
        }
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                int down = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = down + right;
            }
        }
        
        return dp[0][0];
    }
}

// time: O(m*n); space: O(m*n);


