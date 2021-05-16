package leetcode._0055_JumpGame;

// Techbow recursion 超时？return条件有问题
class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums == null) return false;
        if (nums.length == 0) return true;
        
        return helper(nums, 0);
    }
    private boolean helper(int[] nums, int index) {
        if (index >= nums.length - 1) return true; // base case
        
        int jump = nums[index];
        for (int i = 1; i <= jump; i++) { 
            // 这一行无法判断当值为0时是否return false，因为步数有可能从上几步传过来
            // 所以我的方法更好
            if (helper(nums, index + i)) return true;
        }
        // 没有一个return true:
        return false;
    }
}

// time: O(k^n)