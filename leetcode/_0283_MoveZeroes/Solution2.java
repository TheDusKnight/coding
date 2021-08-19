package leetcode._0283_MoveZeroes;

// in-place
// 快慢针
public class Solution2 {
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