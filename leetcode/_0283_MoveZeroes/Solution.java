package leetcode._0283_MoveZeroes;

// sort two unstable solution leetcode过不去
// 双指针站肩 sort two
class Solution {
    public void moveZeroes(int[] nums) {
        // cc
        
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) { // 注意不要写成内部只有if或者while loop的形式，因为这会导致外部的while check失效
            if (nums[l] != 0) l++; // 看到非0，不需要办事，++
            else if (nums[r] == 0) r--; // 看到0，不需要办事，--
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