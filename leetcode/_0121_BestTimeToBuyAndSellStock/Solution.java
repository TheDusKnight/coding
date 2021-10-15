package leetcode._0121_BestTimeToBuyAndSellStock;

// 一维dp
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int n = prices.length;
        int[] buys = new int[n];
        int[] sells = new int[n];
        
        buys[0] = -prices[0]; sells[0] = 0; // 一开始sell没买
        for (int i = 1; i < n; i++) {
            buys[i] = Math.max(buys[i-1], -prices[i]);
            sells[i] = Math.max(sells[i-1], buys[i-1] + prices[i]);
        }
        
        return sells[n-1]; // sell又可能到最后都没买
    }
}

// time: O(N); space: O(N);
