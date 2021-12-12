package leetcode._0416_PartitionEqualSubsetSum;

// 2d dp
class Solution2 {
    public boolean canPartition(int[] nums) {
        // cc
        
        int sum = 0, len = nums.length;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        
        boolean[][] dp = new boolean[len+1][sum/2+1];
        dp[0][0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (j < nums[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
            }
        }
        
        return dp[len][sum/2]; // 尝试完所有点并且subsum为sum/2时就是结果
    }
}

// time: O(n*m). n is nums.length, m is sum/2+1; space: O(n*m);
