package leetcode._0035_SearchInsertPosition;

class Solution {
    public int searchInsert(int[] nums, int target) {
        // cc
        
        int len = nums.length;
        int start = 0, end = len-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid+1;
            else end = mid-1;
        }
        
        return start;
    }
}

// time: O(log(N)); space: O(1);