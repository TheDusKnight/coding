package leetcode._0055_JumpGame;

// 自己 recursion写法, 应该就是greedy
public class Solution {
    public boolean canJump(int[] nums) {
        return recursion(nums, 0, 0);
    }

    private boolean recursion(int[] nums, int index, int step) {
        if (index == nums.length - 1) return true;
        
        // 从上层传下来的剩余步数和当前index可以走的步数取最大的一个
        int longestJump = Math.max(nums[index], step);
        // if (longestJump <= 0) return false;
        
        // for (int i = 1; i <= longestJump; i++) {
        //     return helper(nums, index + i, longestJump - i);
        // }

        if (1 <= longestJump)
            return recursion(nums, index+1, longestJump-1);

        return false;
    }
}