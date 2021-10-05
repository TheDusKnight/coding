package leetcode._0300_LongestIncreasingSubsequence;

// 一维dp
class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        
        int globalMax = 0, n = nums.length;
        // dp[i]含义：从0到i包含i时longest increasing subsequence的长度
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            int curMax = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) curMax = Math.max(curMax, dp[j]);
            }
            dp[i] = curMax + 1;
            globalMax = Math.max(globalMax, dp[i]);
        }
        
        return globalMax;
    }
}

// time: O(N^2); space: O(N);