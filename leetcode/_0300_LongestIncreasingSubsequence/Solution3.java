package leetcode._0300_LongestIncreasingSubsequence;

class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 0;
        for (int i = 0; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                // j可以从i转移过来
                if (nums[i] > nums[j]) maxVal = Math.max(maxVal, dp[j]);
            }
            // index为i，最大值为dp[i]
            dp[i] = maxVal + 1;
            // 全局最大值为全局最大的dp[i]
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }
}
