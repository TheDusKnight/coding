package leetcode._0123_BestTimeToBuyandSellStockIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
            buy1 = nextBuy1;
            sell1 = nextSell1;
            buy2 = nextBuy2;
            sell2 = nextSell2;
            // 依赖反转写法
            // sell2 = Math.max(sell2, buy2 + prices[i]);
            // buy2 = Math.max(buy2, sell1 - prices[i]);
            // sell1 = Math.max(sell1, buy1 + prices[i]);
            // buy1 = Math.max(buy1, -prices[i]);
        }
        return sell2;
    }
    // time: O(n)

    // 高频follow up: 两次交易具体哪天买哪天卖（返回相应的index)？
    public List<Integer> maxProfitIndices(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE, sell1 = 0, sell2 = 0;
        int buy1Idx = -1, buy2Idx = -1, sell1Idx = -1, sell2Idx = -1;
        int maxSell = 0, maxBuyIdx = -1, maxSellIdx = -1;
        HashMap<Integer, List<Integer>> trxn1Map = new HashMap<>();
        HashMap<Integer, Integer> buy2ToSell1Map = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (buy1 < -price) {
                buy1 = -price;
                buy1Idx = i;
            }
            if (sell1 < price + buy1) {
                sell1 = price + buy1;
                sell1Idx = i;
                trxn1Map.put(i, Arrays.asList(buy1Idx, sell1Idx));
            }
            if (buy2 < sell1 - price) {
                buy2 = sell1 - price;
                buy2Idx = i;
                buy2ToSell1Map.put(i, sell1Idx);
            }
            if (sell2 < buy2 + price) {
                sell2 = buy2 + price;
                sell2Idx = i;
            }
            if (maxSell < sell2) {
                maxSell = sell2;
                maxBuyIdx = buy2Idx;
                maxSellIdx = sell2Idx;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (maxSellIdx == -1 && maxBuyIdx == -1) {
            return res; // 如果leetcode验证返回0
        }
        res.add(maxBuyIdx);
        res.add(maxSellIdx);

        Integer sell1Index = buy2ToSell1Map.get(maxBuyIdx);
        if (sell1Index != null && sell1Index != -1) {
            List<Integer> indices = trxn1Map.get(sell1Index);
            if (indices != null) {
                res.add(0, indices.get(1));
                res.add(0, indices.get(0));
            }
        }
        return res;
        // leetcode验证
        // if (res.size() == 4) {
        //     return -prices[res.get(0)] + prices[res.get(1)] - prices[res.get(2)] + prices[res.get(3)];
        // }
        // if (res.size() == 2) {
        //     return -prices[res.get(0)] + prices[res.get(1)];
        // }
        // return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfitIndices(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
        // System.out.println(sol.maxProfitIndices(new int[] { 1, 2, 3, 4, 5 }));
        // System.out.println(sol.maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
    }
}

