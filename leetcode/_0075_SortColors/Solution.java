package leetcode._0075_SortColors;

// sort three, 背下来

// [0,zero) -> 0 [zero, i) -> 0 or 1 [i, n-1] -> ?
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (nums == null || len <= 1) return;
        
        int zero = 0, two = len-1;
        for (int i = 0; i <= two; i++) {
            // 换回的不可能是2，因为2都被换到后面去了，0到zero index区间不会有2
            if (nums[i] == 0) swap(nums, zero++, i);

            // 如果换回的是0还需要往后换
            else if (nums[i] == 2) swap(nums, two--, i--);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

// time: O(n)
// space: O(1)