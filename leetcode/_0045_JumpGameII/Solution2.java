package leetcode._0045_JumpGameII;

// dp space O(N) -> inplace
// 注意跳不到的情况如何处理, option1: 正无穷,option2: array.length
class Solution2 {
    // public int jump(int[] nums) {
    //     // cc
        
    //     int n = nums.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, n);
    //     dp[n-1] = 0;
        
    //     for (int i = n-2; i >= 0; i--) {
    //         int jump = nums[i];
    //         for (int j = 1; j <= jump; j++) {
    //             if (i+j < n) // 和jump gameI不一样没法使用break
    //                 dp[i] = Math.min(dp[i], dp[i+j]+1);
    //         }
    //     }
        
    //     return dp[0] == n ? -1 : dp[0];
    // }

    public int jump(int[] nums) {
        // cc?
        
        int len = nums.length;
        nums[len-1] = 0;
        for (int i = len-2; i >= 0; i--) {
            int jump = nums[i];
            int min = len;
            // 从小到大jump
            for (int j = 1; j <= jump; j++) {
                if (i+j < nums.length)
                    min = Math.min(min, nums[i+j]);
            }
            // 当min没有被更新，说明它到达不了任何地方
            nums[i] = min+1;
        }
        
        return nums[0];
    }
}

// time: O(kn)
// space: O(1)