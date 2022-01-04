package mianjing.amazon_oa.MaximumProfit;

import java.util.List;

// 饼图
public class Solution {
    public static long maxProfit(int k, List<Integer> profit) {
        int n = profit.size();
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += profit.get(i);
            cur += profit.get(n / 2 + i);
        }
        int res = cur;
        for (int i = 1; i < n / 2; i++) {
            cur = cur - profit.get(i-1) + profit.get(i+k-1);
            cur = cur - profit.get(n / 2 + i - 1) * profit.get((n/2 + i + k - 1) % n);
            res = Math.max(res, cur);
        }
        return res;
    }
}
