package leetcode._0238_ProductOfArrayExceptSelf;

// dp
// 向左看乘左边，向右看存右边，最后左边乘右边
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] dpLeft = new int[nums.length];
        int[] dpRight = new int[nums.length];
        int[] dp = new int[nums.length];
        
        // dpLeft[0] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     dpLeft[i] = dpLeft[i-1] * nums[i-1];
        // }
        
        dpRight[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            dpRight[i] = dpRight[i+1] * nums[i+1];
        }
        
        int dpLeft = 1;
        dp[0] = dpLeft * dpRight[0];
        
        for (int i = 1; i < nums.length; i++) {
            // 实时算出dpLeft的值
            dpLeft = dpLeft * nums[i-1];
            dp[i] = dpLeft * dpRight[i];
        }
        return dp;
    }
}

// time: O(n)
// space: O(n)
