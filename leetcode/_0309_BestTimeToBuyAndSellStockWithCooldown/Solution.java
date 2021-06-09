package leetcode._0309_BestTimeToBuyAndSellStockWithCooldown;

public class Solution {
    // 一维dp, O(n) memory
    public int maxProfit(int[] prices) {
        if (prices == null)
            return -1;
        if (prices.length == 0)
            return 0;
        
        int len = prices.length;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        
        for (int i = 1; i < len; i++) {
            // i等于1时不可能卖过，所以是只减去买的价格-prices[i]
            buy[i] = Math.max(buy[i-1], i == 1 ? -prices[i] : sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        
        return sell[len-1];
    }
}

// time: O(n)
