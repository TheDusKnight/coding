package leetcode._0213_HouseRobberII;

// dp
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int len = nums.length;
        return Math.max(rob(nums, 0, len-2), rob(nums, 1, len-1));
    }
    
    private int rob(int[] nums, int start, int end) {
        int dp0 = nums[0 + start], dp1 = Math.max(nums[0 + start], nums[1 + start]), dp2;
        
        for (int i = start + 2; i <= end; i++) {
            dp2 = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1; dp1 = dp2;
        }
        
        return dp1;
    }
}
