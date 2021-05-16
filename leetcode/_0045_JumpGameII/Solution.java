package leetcode._0045_JumpGameII;

// recursion 超时
class Solution {
    int minG = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        // cc ?
        
        jump(nums, 0, 0);
        return minG;
    }
    
    private void jump(int[] nums, int index, int minJump) {
        if (index >= nums.length-1) {
            // 更新最小步数，即层数
            minG = Math.min(minG, minJump);
            return;
        }
        
        int jump = nums[index];
        for (int i = 1; i <= jump; i++) {
            jump(nums, index+i, minJump+1);
        }
    }
}
// time: O(k^n)