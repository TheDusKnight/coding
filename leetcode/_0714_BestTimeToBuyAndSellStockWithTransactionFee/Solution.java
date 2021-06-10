package leetcode._0714_BestTimeToBuyAndSellStockWithTransactionFee;

class Solution {
    // 一维dp 股票问题, O(1) space
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || fee < 0)
            return -1;
        if (prices.length == 0)
            return 0;
        
        int len = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < len; i++) {
            int nextBuy = Math.max(buy, sell - prices[i]);
            int nextSell = Math.max(sell, buy + prices[i] - fee);
            buy = nextBuy; sell = nextSell;
        }
        return sell;
    }
    // time: O(n)
}
