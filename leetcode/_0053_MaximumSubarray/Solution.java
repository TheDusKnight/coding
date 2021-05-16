package leetcode._0053_MaximumSubarray;

// dp
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        
        int len = nums.length;
        int dp = nums[0];
        int globalMax = dp;
        
        for (int i = 1; i < len; i++) {
            if (dp > 0) {
                dp += nums[i];
            } else { // 旧的max val有负向贡献，抛弃
                dp = nums[i];
            }
            globalMax = Math.max(globalMax, dp);
        }
        return globalMax;
    }
}

// time: O(n)
// space: O(1)