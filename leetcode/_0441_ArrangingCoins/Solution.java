package leetcode._0441_ArrangingCoins;

// brute force
class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        
        int rows = 0;
        for (int cur = 1; cur <= n; cur++) {
            if (n - cur >= 0) {
                n -= cur;
                rows++;
            } else break;
        }
        
        return rows;
    }
}