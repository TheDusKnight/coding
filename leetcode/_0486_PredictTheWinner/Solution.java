package leetcode._0486_PredictTheWinner;

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        
        int len = nums.length;
        int[][] dp = new int[len][len];
        int[][] sum = new int[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    sum[i][j] = nums[i];
                    continue;
                }
                sum[i][j] = sum[i][j-1] + nums[j];
            }
        }
        
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = Math.max(nums[i] + (i == len-1 ? 0 : sum[i+1][j] - dp[i+1][j]), nums[j] + (j == 0 ? 0 : sum[i][j-1] - dp[i][j-1]));
            }
        }
        return dp[0][len-1] >= sum[0][len-1] - dp[0][len-1];
    }
}

// time: O(2*n^2)