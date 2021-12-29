package leetcode._0413_ArithmeticSlices;

// 一维dp，dp含义:以i为结尾连续切片的个数
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // cc
        int len = nums.length, sum = 0;
        int[] dp = new int[len];
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp[i] = 1 + dp[i-1];
                sum += dp[i];
            }
        }
        
        return sum;
    }
}

// time: O(N); space: O(N);
