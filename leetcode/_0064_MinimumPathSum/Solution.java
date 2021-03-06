package leetcode._0064_MinimumPathSum;

// 2d dp
public class Solution {
    public int minPathSum(int[][] grid) {
        // cc
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] input = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(sol.minPathSum(input));
    }
}

// time: O(m*n); space: O(m*n);
