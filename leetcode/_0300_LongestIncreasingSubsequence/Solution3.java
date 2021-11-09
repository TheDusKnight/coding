package leetcode._0300_LongestIncreasingSubsequence;

// 一维dp空间无法优化
class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        
        int globalMax = 0, n = nums.length;
        // dp[i]含义：从0到i包含i时longest increasing subsequence的长度
        int[] dp = new int[n];
        dp[0] = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]); // 找到最大的dp[j]
            }
            dp[i] += 1;
            globalMax = Math.max(globalMax, dp[i]);
        }
        
        return globalMax;
    }
}

// time: O(N^2); space: O(N);