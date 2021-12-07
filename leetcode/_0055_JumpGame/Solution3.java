package leetcode._0055_JumpGame;

// dp inplace
class Solution3 {
    public boolean canJump(int[] nums) {
        // cc
        if (nums == null) return false;
        if (nums.length == 0 || nums.length == 1) return true;
        int len = nums.length;
        
        nums[len-1] = -1;
        for (int i = len-2; i >= 0; i--) {
            int jump = nums[i];
            // 由近及远或者由远及近都可以
            for (int j = jump; j > 0; j--) {
                // 如果由近及远可以不用check i+j < nums.length 因为base case就是-1会挡住
                if (i+j < nums.length && nums[i+j] == -1) {
                    nums[i] = -1;
                    break;
                }
            }
        }
        return nums[0] == -1 ? true : false;
    }
}

// time: O(kn)
// space: O(1)
