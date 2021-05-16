package leetcode._0152_MaximumProductSubarray;

// dp
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int global_max = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            // 有可能cur单值最大或最小
            int tmp_max = Math.max(cur, Math.max(max_so_far * cur, min_so_far * cur));
            min_so_far = Math.min(cur, Math.min(max_so_far * cur, min_so_far * cur));
            
            max_so_far = tmp_max;
            // global_max为max_so_far中最大的值
            global_max = Math.max(max_so_far, global_max);
        }
        return global_max;
    }
}

// time: O(n)
// space: O(1)
