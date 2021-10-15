package leetcode._0121_BestTimeToBuyAndSellStock;

public class Solution2 {
    // dp 股票问题
    public int maxProfit(int[] prices) {
        if (prices == null)
            return -1;
        if (prices.length == 0)
            return 0;
        
        int len = prices.length;
        // 初始化buy和sell第0天的值
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < len; i++) {
            // i可以初始化为0或者1,
            // 只要确保第0天buy初始化为-prices[0], sell初始化为0就行
            int nextBuy = Math.max(buy, -prices[i]);
            int nextSell = Math.max(sell, buy + prices[i]);
            buy = nextBuy;
            sell = nextSell;
        }
        return sell;
    }
}

// time: O(n)