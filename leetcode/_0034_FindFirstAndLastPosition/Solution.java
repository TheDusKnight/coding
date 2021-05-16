package leetcode._0034_FindFirstAndLastPosition;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // cc
        int[] res = new int[] {-1, -1};
        if (nums == null || nums.length == 0) return res;

        res[0] = findLeftIndex(nums, target);
        if (res[0] == -1) return new int[] {-1, -1};
        res[1] = findRightIndex(nums, target);
        return res;
    }
    // 一直往左找，一直找到最左边的和target相等的数的位置，如果没找到返回right的位置如果和target相等，否则返回-1
    private int findLeftIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        return nums[right] == target ? right:-1;
    }
    // 同理
    private int findRightIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid]) right = mid;
            else left = mid;
        }
        if (nums[right] == target) return right;
        return nums[left] == target ? left:-1;
    }
}
