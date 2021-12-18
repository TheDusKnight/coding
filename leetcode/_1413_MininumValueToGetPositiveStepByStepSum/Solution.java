package leetcode._1413_MininumValueToGetPositiveStepByStepSum;

// prefix sum
class Solution {
    public int minStartValue(int[] nums) {
        // cc
        
        int curSum = 0, min = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            min = Math.min(min, curSum);
        }
        
        return min >= 0 ? 1 : -min + 1;
    }
}