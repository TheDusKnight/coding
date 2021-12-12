package leetcode._0416_PartitionEqualSubsetSum;

import java.util.Arrays;

// 1d dp
class Solution3 {
    public boolean canPartition(int[] nums) {
        // cc
        
        int sum = 0, len = nums.length;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        
        boolean[] dp = new boolean[sum/2+1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            boolean[] newDp = Arrays.copyOf(dp, dp.length);
            for (int j = 1; j <= sum/2; j++) {
                if (j < nums[i-1])
                    newDp[j] = dp[j];
                else
                    newDp[j] = dp[j-nums[i-1]] || dp[j];
            }
            dp = newDp;
        }
        
        return dp[sum/2]; // 尝试完所有点并且sub sum为sum/2时就是结果
    }
}

// time: O(n*m). n is nums.length, m is sum/2+1; space: O(m);
