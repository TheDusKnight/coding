package leetcode._0153_FindMinimumInRotatedSortedArray;

// Binary search 左右相邻解法
// 看解析图为什么 r = mid 而 l = mid +1
// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-5irwp/
public class Solution2 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1, mid;
        // 这一步判断数组是否旋转过，即数组是否单调递，优化时间复杂度
        if (nums[r] > nums[0]) return nums[0];
        while (l + 1 < r) { // 左右相邻
            mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid; // mid本身也有可能是最小值
            } else {
                l = mid + 1; // mid本身不可能为最小值
            }
        }
        return nums[l] < nums[r] ? nums[l] : nums[r];
    }

    // 左右相等也可以做
    // public int findMin(int[] nums) {
    //     int n = nums.length;
    //     int left = 0, right = n-1, mid = 0;
    //     if (nums[left] < nums[right]) return nums[left];
        
    //     while (left < right) {
    //         mid = left + (right - left) / 2;
    //         if (nums[mid] > nums[right]) {
    //             left = mid + 1;
    //         } else {
    //             right = mid;
    //         }
    //     }
        
    //     // return Math.min(nums[left], nums[right]);
    //     return nums[left];
    // }
}

// time: O(log(n)); space: O(1)
