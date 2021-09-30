package leetcode._0041_FirstMissingPositive;

// mark negative + index as a hash key, 和287. Find the Duplicate Number, solution3 mark negative类似
// https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
class Solution2 {
    public int firstMissingPositive(int[] nums) {
        // cc
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0)
                nums[i] = n+1;
        }
        
        for (int i = 0; i < n; i++) {
            int cur = Math.abs(nums[i]);
            if (cur >= 1 && cur <= n && nums[cur - 1] > 0) {
                nums[cur - 1] = -nums[cur - 1];
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i+1;
        }
        
        return n+1;
    }
}

// time: O(n); space: O(1);
