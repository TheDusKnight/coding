package leetcode._0413_ArithmeticSlices;

// O(1) dp
class Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        // cc
        int len = nums.length, sum = 0;
        int dp = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                dp = 1 + dp;
                sum += dp;
            } else dp = 0;
        }
        
        return sum;
    }
}

// time: O(N); space: O(1);
