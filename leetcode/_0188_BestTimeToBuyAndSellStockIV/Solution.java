package leetcode._0188_BestTimeToBuyAndSellStockIV;

class Solution {
    // dp 股票
    public int maxProfit(int k, int[] prices) {
        if (k < 0 || prices == null)
            return -1;
        if (k == 0 || prices.length == 0)
            return 0;
        
        int len = prices.length;
        int[][] buy = new int[k+1][len];
        int[][] sell = new int[k+1][len];
        for (int i = 0; i < k+1; i++) {
            buy[i][0] = -prices[0];
        }
        
        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < len; j++) {
                buy[i][j] = Math.max(buy[i][j-1], sell[i-1][j-1] - prices[j]);
                sell[i][j] = Math.max(sell[i][j-1], buy[i][j-1] + prices[j]);
            }
        }
        return sell[k][len-1];
    }

    // space: O(N*K); time: O(N*K);
}
