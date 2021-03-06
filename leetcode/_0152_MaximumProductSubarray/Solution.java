package leetcode._0152_MaximumProductSubarray;

// 讨论正负，是否有0，比较和53的异同
// dp保存两个极值
class Solution {
    public int maxProduct(int[] nums) {
        // cc
        
        // dpMax, dpMin
        int curMax = nums[0], curMin = nums[0], max = nums[0], n = nums.length;
        
        for (int i = 1; i < n; i++) {
            int cur = nums[i];
            // 忘记max和min是和cur比较而不是curMax或curMin
            int tmpMax = Math.max(cur, Math.max(curMax * cur, curMin * cur));
            curMin = Math.min(cur, Math.min(curMax * cur, curMin * cur));
            curMax = tmpMax;
            
            max = Math.max(max, curMax);
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,-1,-2};;
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(nums));
    }
}

// time: O(N); space: O(1);
