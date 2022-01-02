package leetcode._0300_LongestIncreasingSubsequence;

import java.util.Arrays;

// 一维dp无法优化
class Solution3 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) throw new IllegalArgumentException();
        if (nums.length == 0) return 0;
        
        int len = nums.length, max = 1; // max最小为1
        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 每一位dp最小伟1
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1); // 找到最大的dp[i]
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}

// time: O(n^2); space: O(N);