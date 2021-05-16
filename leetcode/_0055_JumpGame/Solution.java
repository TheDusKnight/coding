package leetcode._0055_JumpGame;

// 自己 recursion写法
public class Solution {
    public boolean canJump(int[] nums) {
        return helper(nums, 0, 0);
    }

    private boolean helper(int[] nums, int index, int step) {
        if (index == nums.length - 1) return true;
        
        // 从上层传下来的剩余步数和当前index可以走的步数取最大的一个
        int longestJump = Math.max(nums[index], step);
        // if (longestJump <= 0) return false;
        
        for (int i = 1; i <= longestJump; i++) {
            // step = nums[index] - i;
            return helper(nums, index + i, longestJump - i);
        }
        return false;
    }
}