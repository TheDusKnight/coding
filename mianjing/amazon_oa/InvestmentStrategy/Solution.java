package mianjing.amazon_oa.InvestmentStrategy;

public class Solution {
    public int investment(int n, int[][] rounds) {
        int[] invest = new int[n];
        for (int[] round : rounds) {
            invest[round[0] - 1] += round[2];
            if (round[1] < n) {
                invest[round[1]] -= round[2];
            }
        }
        int cur = 0;
        int max = 0;
        for (int value : invest) {
            cur += value;
            max = Math.max(cur, max);
        }
        return max;
    }
}
