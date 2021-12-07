package leetcode._0055_JumpGame;

// dp
class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return true;
        
        int len = nums.length;
        // dp[0] == true; dp[i] == true if any of position it can see is true
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) { //从近到远
                // if (i+j >= len || dp[i+j]) {
                //     dp[i] = true;
                //     break;
                // }
                if (dp[i+j]) { // 可以不用加condition因为有break，并且dp[len-1]一定为true
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // for (int i = len - 2; i >= 0; i--) {
        //     for (int j = nums[i]; j > 0; j--) { // 从远到近
        //         if (i+j >= len-1 || dp[i+j]) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        
        return dp[0];
    }
}

// time: O(k*N); space: O(N);
