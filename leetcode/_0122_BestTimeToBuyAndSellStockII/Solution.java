package leetcode._0122_BestTimeToBuyAndSellStockII;

public class Solution {
    // O(1) dp，和121唯一的变化就是nextBuy从sell-prices[i]转移过来而不是-prices[i]
    public int maxProfit(int[] prices) {
        if (prices == null)
            return -1;
        if (prices.length == 0)
            return 0;
        
        int len = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < len; i++) {
            int nextBuy = Math.max(buy, sell - prices[i]);
            int nextSell = Math.max(sell, buy + prices[i]);
            buy = nextBuy; sell = nextSell;
        }
        return sell;
    }
}

// time: O(n); space: O(1);