package leetcode._0283_MoveZeroes;

// 0以外的数stable
// 快慢针
// [0,left] 0
// [left, i) 1
// [i, right] ?
// (right,n-1] 2
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] != 0) {
                swap(nums, slow++, fast);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}