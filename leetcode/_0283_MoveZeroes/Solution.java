package leetcode._0283_MoveZeroes;

// sort two unstable solution leetcode过不去
class Solution {
    public void moveZeroes(int[] nums) {
        // cc
        
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            if (nums[l] != 0) l++;
            else if (nums[r] == 0) r--;
            else swap(nums, l, r);
        }
        if (nums[l] == 0 && nums[r] != 0)
            swap(nums, l, r);
    }
    
    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}

// time: O(n);