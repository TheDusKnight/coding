package leetcode._0045_JumpGameII;

// dp inplace
// 注意跳不到的情况如何处理, option1: 正无穷,option2: array.length
class Solution2 {
    // public int jump(int[] nums) {
    //     // cc?
        
    //     int len = nums.length;
    //     nums[len-1] = 0;
    //     for (int i = len-2; i >= 0; i--) {
    //         int jump = nums[i];
    //         int min = Integer.MAX_VALUE;
    //         // 从小到大jump
    //         for (int j = 1; j <= jump; j++) {
    //             if (i+j < nums.length)
    //                 min = Math.min(min, nums[i+j]);
    //         }
    //         // 当min没有被更新，说明它到达不了任何地方
    //         nums[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min+1;
    //     }
        
    //     return nums[0];
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