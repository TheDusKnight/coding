package leetcode._0322_CoinChange;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return dfs(coins, amount, new int[amount + 1]);
    }
    
    private int dfs(int[] coins, int rem, int[] minCount) { // minCount指当前remaining amount所需的最小coins
        if (rem == 0) {
            return 0;
        }
        if (rem < 0) {
            return -1;
        }
        if (minCount[rem] != 0) return minCount[rem];
        
        int min = Integer.MAX_VALUE;
        for (int coin: coins) {
            int res = dfs(coins, rem - coin, minCount);
            if (res >= 0 && res < min) {
                min = res + 1; // 尝试更新这一层dfs的min
            }
        }
        
        minCount[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return minCount[rem];
    }
}

// time: n * amount. n is number of coins
