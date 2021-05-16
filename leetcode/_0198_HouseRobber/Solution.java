package leetcode._0198_HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prevMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            int tmp = curMax;
            // 从前一个index过来说明curMax没变，从其他位置过来说明之前max加当前房子价值
            curMax = Math.max(prevMax + nums[i], curMax);
            prevMax = tmp;
        }
        return curMax;
    }
}