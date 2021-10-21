package leetcode._0322_CoinChange;

// dfs + pruning
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        
        int[] memo = new int[amount+1];
        return recursion(coins, amount, memo);
    }
    
    private int recursion(int[] coins, int remains, int[] memo) {
        if (remains == 0) {
            return 0;
        }
        if (remains < 0) {
            return -1;
        }
        
        if (memo[remains] != 0) return memo[remains];
        
        int min = remains+1;
        for (int coin: coins) {
            int res = recursion(coins, remains-coin, memo);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        
        memo[remains] = (min == remains+1 ? -1 : min);
        return memo[remains];
    }
}

// time: n * amount. n is number of coins
