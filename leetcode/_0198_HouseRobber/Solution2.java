package leetcode._0198_HouseRobber;

// 常数dp
// 和Min Cost Climbing Stairs最大的不同在于初始化的不同
class Solution2 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int dp1 = nums[0], dp2 = Math.max(nums[0], nums[1]), dp3 = dp2;
        
        for (int i = 2; i < n; i++) {
            dp3 = Math.max(dp2, dp1 + nums[i]);
            dp1 = dp2;
            dp2 = dp3;
        }
        
        return dp3;
    }
}

// time: O(N); space: O(1);