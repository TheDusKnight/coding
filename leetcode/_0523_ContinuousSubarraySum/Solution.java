package leetcode._0523_ContinuousSubarraySum;

// prefix sum, 一维DP
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + nums[i];
            if (dp[i] % k == 0) return true;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i+2; j < n; j++) {
                if ((dp[j] - dp[i]) % k == 0) return true;
            }
        }
        
        return false;
    }
}

// time: O(N^2) 超时; space: O(N);
