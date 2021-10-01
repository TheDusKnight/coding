package leetcode._0154_FindMinimumInRotatedSortedArrayII;

// Binary search
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int l = 0, r = nums.length - 1, mid;
        // 因为题目说val有可能重复，所以不能判断
        // 这一步判断数组是否旋转过，即数组是否单调递，优化时间复杂度
        // if (numbers[r] > numbers[0])
        //     return numbers[0];

        while (l + 1 < r) { // 左右相邻
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid; // mid本身也有可能是最小值
            } else if (nums[mid] > nums[r]) {
                l = mid + 1; // mid本身不可能为最小值
            } else {
                r--; // 如果mid和r相等，最右边的val扔掉
            }
        }
        return Math.min(nums[l], nums[r]);
    }

    // 左右相等也可以做
    // public int findMin(int[] nums) {
    //     int n = nums.length;
    //     int left = 0, right = n-1, mid = 0;
        
    //     while (left < right) {
    //         mid = left + (right - left) / 2;
    //         if (nums[mid] > nums[right]) {
    //             left = mid + 1;
    //         } else if (nums[mid] < nums[right]) {
    //             right = mid;
    //         } else {
    //             right--;
    //         }
    //     }
        
    //     // return Math.min(nums[left], nums[right]);
    //     return nums[left];
    // }
}
