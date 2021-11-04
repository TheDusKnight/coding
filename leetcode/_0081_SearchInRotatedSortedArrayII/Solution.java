package leetcode._0081_SearchInRotatedSortedArrayII;

// lc33 follow up
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length < 1) return false;
        
        int n = nums.length;
        int left = 0, right = n-1;
        // 有且只有当最左和最右值相等时，分界线左右区域同时出现了相同值则无法判断当前值所处区域
        if (nums[left] == nums[right]) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) return true;
            }
            return false;
        }
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] >= nums[0]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n-1]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        
        return false;
    }
}

// time: O(log(N) ~ N); space: O(1)
