package leetcode._0075_SortColors;

// quick sort中sort two做两遍
class Solution2 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (nums == null || len <= 1) return;
        
        int left = 0, right = len-1;
        while (left <= right) { // 左右越过因为left必须不能是0
            if (nums[left] != 0 && nums[right] == 0) {
                swap(nums, left, right);
            }
            if (nums[left] == 0) left++;
            if (nums[right] != 0) right--;
        }
        // System.out.println(left);
        
        right = len-1;
        while (left < right) {
            if (nums[left] != 1 && nums[right] == 1) {
                swap(nums, left, right);
            }
            if (nums[left] == 1) left++;
            if (nums[right] != 1) right--;
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
