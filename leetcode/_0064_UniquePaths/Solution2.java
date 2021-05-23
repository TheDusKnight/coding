package leetcode._0064_UniquePaths;

public class Solution2 {
    // 2d dp
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    // time: O(n*m); space: O(n*m);

    // 1d dp
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
    // time: O(n*m); space: O(n);

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.uniquePaths2(5, 10));
    }
}


