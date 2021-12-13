package leetcode._0746_MinCostClimbingStairs;

// dp
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) throw new IllegalArgumentException();
        
        int len = cost.length;
        int dp0 = cost[0], dp1 = cost[1], dp2;
        if (len == 1) return dp0;
        if (len == 2) return Math.min(dp0, dp1);
        
        for (int i = 2; i < len; i++) {
            dp2 = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = dp2;
        }
        
        return Math.min(dp0, dp1); // cost to get to the top
    }
}
