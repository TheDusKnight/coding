package leetcode._0055_JumpGame;

// Greedy, 每次尝试将maxIndex更新�️更远
class Solution4 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 0) return false;
        if (n == 1) return true;
        
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            maxIndex = Math.max(nums[i]+i, maxIndex);
            if (maxIndex >= n-1) return true;
            if (i >= maxIndex) return false;
        }
        
        throw new IllegalArgumentException("You should not see it");
    }
}