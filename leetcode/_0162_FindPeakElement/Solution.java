package leetcode._0162_FindPeakElement;

// binary search不断和后一个值比较，找可能的峰值区间

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return 0;
        
        int n = nums.length;
        int left = 0, right = n-1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid + 1 >= n) break; // 例如 {1,2}时mid+1会出界
            if (nums[mid] > nums[mid+1]) { // 找可能的峰值区域
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }
}

// time: O(log(N)); space: O(1);
