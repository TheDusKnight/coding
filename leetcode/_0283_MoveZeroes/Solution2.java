package leetcode._0283_MoveZeroes;

// slow补0实现真stable
class Solution2 {
    public void moveZeroes(int[] nums) {
        // cc
        
        int slow = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[slow++] = nums[i];
            }
        }
        
        while (slow < n) {
            nums[slow++] = 0;
        }
    }
}

// time: O(N); space: O(1);