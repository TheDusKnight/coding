package leetcode._0486_PredictTheWinner;

class Solution2 {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        
        int len = nums.length;
        int[][] dp = new int[len][len];
        int sum = 0;
        
        for (int i = len-1; i >= 0; i--) {
            sum += nums[i];
            for (int j = i; j < len; j++) {
                int a = i+2 <= j ? dp[i+2][j] : 0;
                int b = i+1 <= j-1 ? dp[i+1][j-1] : 0;
                int c = i <= j-2 ? dp[i][j-2] : 0;
                dp[i][j] = Math.max(nums[i] + Math.min(a,b), nums[j] + Math.min(c, b));
            }
        }
        return dp[0][len-1] >= sum - dp[0][len-1];
    }
}

// time: O(n^2)