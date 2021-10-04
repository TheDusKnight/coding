package leetcode._0045_JumpGameII;

// recursion带检查是否能跳到超时
class Solution4 {
    int minSteps;
    public int jump(int[] nums) {
        // cc
        
        minSteps = nums.length;
        Boolean[] memo = new Boolean[nums.length];
        if (recursion(nums, 0, memo, 0)) return minSteps;
        return -1;
    }
    
    private boolean recursion(int[] nums, int idx, Boolean[] memo, int steps) {
        if (idx >= nums.length-1) {
            minSteps = Math.min(minSteps, steps);
            return true;
        }
        
        if (memo[idx] != null && !memo[idx]) return memo[idx];
        
        int jump = nums[idx];
        for (int i = 1; i <= jump; i++) {
            if (recursion(nums, idx+i, memo, steps+1)) {
                // return true;
                memo[idx] = true;
            }
        }
        
        if (memo[idx] != null) return memo[idx];
        
        memo[idx] = false;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,0,1,4};
        Solution4 sol = new Solution4();
        System.out.println(sol.jump(nums));
    }
}
