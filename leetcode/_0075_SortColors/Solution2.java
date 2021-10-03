package leetcode._0075_SortColors;

// move zeros做两遍
class Solution2 {
    public void sortColors(int[] nums) {
        // cc
        
        int n = nums.length;
        int zero = n-1;
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] != 0) {
                swap(nums, i, zero--);
            }
        }
        
        int one = n-1;
        for (int i = n-1; i > zero; i--) {
            if (nums[i] != 1) {
                swap(nums, i, one--);
            }
        }
    }
    
    private void swap(int[] nums, int i , int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

// time: O(n)
// space: O(1)
