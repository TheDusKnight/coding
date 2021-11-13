package mianjing.google._1509_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves;

import java.util.Arrays;

// Google OA
// sort后找4种可能性
class Solution {
    public int minDifference(int[] nums) {
        if (nums == null || nums.length <= 4) return 0;
        
        Arrays.sort(nums);
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; i++) {
            diff = Math.min(nums[len-1-(3-i)] - nums[i], diff);
        }
        
        return diff;
    }
}

// O(N*log(N)); time: O(1);
