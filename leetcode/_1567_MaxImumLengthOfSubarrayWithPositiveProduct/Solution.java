package leetcode._1567_MaxImumLengthOfSubarrayWithPositiveProduct;

// dp保存正数的长度和负数的长度
class Solution {
    public int getMaxLen(int[] nums) {
        // cc
        int len = nums.length, pos = 0, neg = 0, maxLen = 0;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (cur == 0) {
                neg = 0;
                pos = 0;
            } else if (cur > 0) {
                pos++;
                neg = neg == 0 ? 0 : neg+1;
            } else {
                int tmpPos = neg == 0 ? 0 : neg+1;
                neg = pos+1;
                pos = tmpPos;
            }
            maxLen = Math.max(maxLen, pos);
        }
        
        return maxLen;
    }
}

// time: O(N); space: O(1);
