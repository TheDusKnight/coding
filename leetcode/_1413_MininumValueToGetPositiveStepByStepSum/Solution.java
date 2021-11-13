package leetcode._1413_MininumValueToGetPositiveStepByStepSum;

// binary search
class Solution {
    public int minStartValue(int[] nums) {
        // cc
        
        int start = 1, end = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (validStepSum(nums, mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return start;
    }
    
    private boolean validStepSum(int[] nums, int target) {
        for (int num: nums) {
            target += num;
            if (target < 1) return false;
        }
        
        return true;
    }
}

// time: O(n⋅log(mn));
// Let nn be the length of the array nums and mm be the absolute value of the lower bound of elements in nums.
