package leetcode._0416_PartitionEqualSubsetSum;

// dfs + pruning
class Solution {
    int[] nums;
    int len;
    public boolean canPartition(int[] nums) {
        // cc
        
        this.nums = nums;
        int sum = 0;
        len = nums.length;
        for (int num: nums) sum += num;
        if (sum % 2 != 0) return false;
        
        Boolean[][] memo = new Boolean[sum/2+1][len];
        return dfs(sum/2, 0, memo);
    }
    
    private boolean dfs(int sum, int idx, Boolean[][] memo) {
        if (sum == 0) return true;
        if (idx >= len || sum < 0) { // idx为len时的状态不需要保存
            return false;
        }
        if (memo[sum][idx] != null) return memo[sum][idx];
        
        boolean ret = dfs(sum - nums[idx], idx+1, memo) || dfs(sum, idx+1, memo);
        memo[sum][idx] = ret;
        return ret;
    }
}

// time: O((sum/2+1)*n); space: O((sum/2+1)*n) stack消耗小于memo消耗;
