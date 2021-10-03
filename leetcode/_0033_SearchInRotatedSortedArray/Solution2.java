package leetcode._0033_SearchInRotatedSortedArray;

class Solution2 {
    public int search(int[] nums, int target) {
        // cc
        
        int n = nums.length, left = 0, right = n-1, mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[n-1]) { // 拐点在mid右边
                // 确定target是否位于non-rotated sub-array
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else { // 拐点在mid左边
                if (target > nums[mid] && target <= nums[n-1]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        
        return nums[left] == target ? left : -1;
    }
}

// time: O(log(N)); space: O(1);
