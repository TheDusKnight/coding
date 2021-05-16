package leetcode._0300_LongestIncreasingSubsequence;

// recursion
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        
        return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
    }
    
    public int lengthOfLIS(int[] nums, int prev, int index) {
        if (index == nums.length) return 0;
        
        int taken = 0;
        if (nums[index] > prev) {
            taken = 1 + lengthOfLIS(nums, nums[index], index+1);
        }
        int notTaken = lengthOfLIS(nums, prev, index+1);
        return Math.max(taken, notTaken);
    }
}

// time: O(2^n)
// 每次分两个叉，一共n层
