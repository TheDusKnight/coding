package leetcode._0283_MoveZeroes;

// in-place
// 指针问题，背下来
public class Solution2 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, zero++, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}