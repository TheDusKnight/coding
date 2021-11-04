package leetcode._0153_FindMinimumInRotatedSortedArray;

// binary search
class Solution2 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        if (nums[0] < nums[n-1]) return nums[0];
        
        int left = 0, right = n-1;
        while (left <= right) { // 找分界点
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) { // 注意相等时的情况
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return nums[left];
    }
}

// time: O(log(N)); space: O(1);
