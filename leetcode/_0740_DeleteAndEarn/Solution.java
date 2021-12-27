package leetcode._0740_DeleteAndEarn;

// DP, similar to house robber
class Solution {
    private static final int N = 10000;
    public int deleteAndEarn(int[] nums) {
        // cc
        int[] buckets = new int[N+1];
        for (int num: nums) buckets[num] += num;
        
        int dp0 = buckets[0], dp1 = Math.max(buckets[0], buckets[1]), dp2;
        
        for (int i = 2; i <= N; i++) {
            dp2 = Math.max(dp1, dp0 + buckets[i]);
            dp0 = dp1; dp1 = dp2;
        }
        
        return dp1;
    }
}
