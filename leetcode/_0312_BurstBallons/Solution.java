package leetcode._0312_BurstBallons;

class Solution {
    // 2d dp
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // Select best k within [i,j]
                for (int k = i; k <= j; k++) {
                    // 看example，先留k，找左找右值，然后根据左边打光和右边打光的idx计算k
                    int left = k==i ? 0 : dp[i][k-1];
                    int right = k==j ? 0 : dp[k+1][j];
                    int mid = nums[k] * (i==0 ? 1 : nums[i-1]) * (j==len-1 ? 1 : nums[j+1]);
                    // 同时初始化和转移方程效果
                    dp[i][j] = Math.max(dp[i][j], left+right+mid);
                }
            }
        }
        return dp[0][len-1];
    }
}
// O(n^3)