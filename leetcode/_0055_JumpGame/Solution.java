package leetcode._0055_JumpGame;

// recursion
class Solution {
    public boolean canJump(int[] nums) {
        // cc
        
        boolean[] memo = new boolean[nums.length];
        return recursion(nums, 0, memo);
    }
    
    private boolean recursion(int[] nums, int idx, boolean[] memo) {
        if (idx >= nums.length-1) {
            return true;
        }
        
        if (memo[idx]) return false;
        
        int steps = nums[idx];
        for (int i = 1; i <= steps; i++) {
            if (recursion(nums, idx+i, memo)) {
                return true;
            }
        }
        
        memo[idx] = true;
        return false;
    }
}

// // time: O(k^N) 不加memo -> O(k*N). k是最大步数; space: O(N);