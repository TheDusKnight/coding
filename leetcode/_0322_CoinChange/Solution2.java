package leetcode._0322_CoinChange;

import java.util.Arrays;

// dp
class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int max = amount + 1; // max是一个coin总数永远无法到达的值,需要比amount大
        int[] dp = new int[amount + 1]; // 你永远无法用5个硬币换4块钱，硬币最小单位为1
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { // 如果if进不去，当前dp[i]不会更新，也就有后面的post check
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
        
    }
}

// time: O(n*amount);