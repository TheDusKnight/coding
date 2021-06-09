package leetcode._0123_BestTimeToBuyandSellStockIII;

class Solution {
    // 一维dp similar to 121
    public int maxProfit(int[] prices) {
        if (prices == null)
            return -1;
        if (prices.length == 0)
            return 0;
        
        int len = prices.length;
        // buy2 如果在第0天买，那么buy2就是buy1，sell2就是sell1
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        // int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for (int i = 1; i < len; i++) { // 反转需要把i改成0
            // 下一轮的值不要影响这一轮
            int nextBuy1 = Math.max(buy1, -prices[i]);
            int nextSell1 = Math.max(sell1, buy1 + prices[i]);
            int nextBuy2 = Math.max(buy2, sell1 - prices[i]);
            int nextSell2 = Math.max(sell2, buy2 + prices[i]);
            buy1 = nextBuy1; sell1 = nextSell1; buy2 = nextBuy2; sell2 = nextSell2;
            // 依赖反转写法
            // sell2 = Math.max(sell2, buy2 + prices[i]);
            // buy2 = Math.max(buy2, sell1 - prices[i]);
            // sell1 = Math.max(sell1, buy1 + prices[i]);
            // buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
    }
}

// time: O(n)
