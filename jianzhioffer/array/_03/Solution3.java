package jianzhioffer.array._03;

// 利用index与val一对多关系
// 原地交换
class Solution3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 两个不同位置的数调换后相等则重复
            if (nums[nums[i]] == nums[i] && nums[i] != i) {
                return nums[i];
            }

            if (nums[i] != i) {
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// time: O(n); space: O(1)
