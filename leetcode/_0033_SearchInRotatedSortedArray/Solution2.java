package leetcode._0033_SearchInRotatedSortedArray;

// 做一次binary search分类讨论
class Solution2 {
    public int search(int[] nums, int target) {
        // cc
        
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[0]) {
                if (target < nums[mid] && target >= nums[0]) {
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
        
        return -1;
    }
}

// time: O(log(N)); space: O(1);
