package leetcode._0309_BestTimeToBuyAndSellStockWithCooldown;

public class Solution2 {
    // dp, O(1) memory
    public int maxProfit(int[] prices) {
        if (prices == null)
            return -1;
        if (prices.length == 0)
            return 0;
        
        int len = prices.length;
        int buy1 = -prices[0], sell1 = 0, buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < len; i++) {
            // 这边sell1代表上一个sell的值，原本应该转移给新一轮的nextBuy1，但跳了一步传给了nextBuy2，说明第一次buy的机会被放弃了
            // 跳过一次buy和sell，上次的sell变成的上上次
            int nextBuy2 = Math.max(buy2, sell1 - prices[i]); // 第一次不买，第二次才买
            int nextSell2 = Math.max(sell2, buy2 + prices[i]);
            buy1 = buy2; sell1 = sell2; buy2 = nextBuy2; sell2 = nextSell2;
        }
        return sell2;
    }
}

// time: O(n), 运行速度快0秒
