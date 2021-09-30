package leetcode._0287_FindTheDuplicateNumber;

// negative marking, 不能完全满足题意
class Solution {
    public int findDuplicate(int[] nums) {
        // cc
        
        Integer dup = null;
        for (int n: nums) {
            int flip = nums[Math.abs(n)];
            if (flip < 0) {
                dup = Math.abs(n);
                break;
            }
            nums[Math.abs(n)] = -flip;
        }
        
        if (dup == null) return -1;
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        
        return dup;
    }
}

// time: O(n);
