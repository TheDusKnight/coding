package leetcode._0034_FindFirstAndLastPosition;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1,-1};
        if (nums.length == 0) return res;
        
        int n = nums.length;
        int left = 0, right = n-1;
        // 找左边界
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        // check target是否存在
        if (left >= n || nums[left] != target) return res;
        res[0] = left;
        // 找右边界
        left = 0; right = n-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        res[1] = right;
        
        return res;
    }
}

// time: O(log(N)); space: O(1);