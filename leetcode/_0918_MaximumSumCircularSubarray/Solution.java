package leetcode._0918_MaximumSumCircularSubarray;

// prefix sum
// https://leetcode.com/problems/maximum-sum-circular-subarray/discuss/178422/One-Pass
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        
        int len = nums.length, max = nums[0], min = nums[0], curMax = 0, curMin = 0, sum = 0;
        boolean allNegative = true; // 必须判断是否全部是负数，如果是那么根据题意return最大的元素
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (nums[i] > 0) allNegative = false;
            
            curMax += nums[i];
            curMin += nums[i];
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
            
            if (curMax <= 0) curMax = 0;
            if (curMin >= 0) curMin = 0;
        }
        
        if (allNegative) return max;
        return Math.max(max, sum - min);
    }
}

// time: O(N); space: O(1);
