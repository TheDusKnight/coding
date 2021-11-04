package leetcode._0154_FindMinimumInRotatedSortedArrayII;

// Binary search
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int left = 0, right = n-1;
        // 这一步判断数组是否旋转过，即数组是否单调递，优化时间复杂度
        if (nums[left] < nums[right]) return nums[left];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid+1; // [mid, left]一定不是最小
            } else if (nums[mid] < nums[right]) {
                right = mid; // (mid, right]一定不是最小
            } else {
                right--; // nums[mid]和nums[right]相等无法判断,right减一
            }
        }
        
        return nums[left];
    }
}

// time: O(log(N) ~ O(N)); space: O(1);
