package leetcode._0075_SortColors;

// quick sort中sort two做两遍
class Solution2 {
    public void sortColors(int[] nums) {
        // cc
        
        int n = nums.length;
        int l = 0, r = n-1;
        while (l <= r) { // 左右越过因为left必须不能是0，后面要用到left指针从非0出发
            if (nums[l] == 0) l++;
            else if (nums[r] != 0) r--;
            else swap(nums, l, r);
        }
        
        r = n - 1;
        while (l <= r) { // 也可以是l < r
            if (nums[l] == 1) l++;
            else if (nums[r] != 1) r--;
            else swap(nums, l, r);
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
