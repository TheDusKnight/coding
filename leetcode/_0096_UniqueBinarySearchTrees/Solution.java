package leetcode._0096_UniqueBinarySearchTrees;

// https://leetcode-cn.com/problems/unique-binary-search-trees/solution/hua-jie-suan-fa-96-bu-tong-de-er-cha-sou-suo-shu-b/
// 一维dp
class Solution {
    public int numTrees(int n) {
        // cc
        
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // dp[i-j]错写成dp[n-j]
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        
        return dp[n];
    }
}

// time: O(N^2); space: O(N);
