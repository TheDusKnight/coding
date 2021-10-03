package leetcode._0033_SearchInRotatedSortedArray;

// binary search two iterations
class Solution {
    public int search(int[] nums, int target) {
        // cc
        
        int n = nums.length;
        int left = 0, right = n-1, mid = 0;
        
        
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        int minIdx = left;
        if (target <= nums[n-1]) { // if else顺序不能变，等于条件不能变
            left = minIdx;
            right = n-1;
        } else if (target >= nums[0]) {
            left = 0;
            right = minIdx; // min元素包含在search中不过没有关系
        } else {
            return -1;
        }
        
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return nums[left] == target ? left : -1; // 最后看下找到的元素是否确实是target
    }
}

// time: O(2 * log(N)); space: O(1);
