package mianjing.amazon_oa.BadNumber;

public class Solution {
    public int badNumber(int[] badNumbers, int lower, int upper) {
        int len = badNumbers.length, res = 0, pre = lower - 1;
        for (int i = 0; i <= len; i++) {
            int cur = (i < badNumbers.length) ? badNumbers[i] : upper + 1;
            if (pre + 1 <= cur - 1) res = Math.max(res, cur - pre - 1);
            pre = cur;
        }

        return res;
    }
}
