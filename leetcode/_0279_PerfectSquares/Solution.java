package leetcode._0279_PerfectSquares;

// brute force
class Solution {
    int minCount = 10000;
    public int numSquares(int n) {
        if (n <= 0) return -1;
        
        dfs(n, 0);
        return minCount;
    }
    
    private void dfs(int n, int count) {
        if (n == 0) {
            minCount = Math.min(count, minCount);
            return;
        }
        if (n < 0) return;
        
        for (int i = 100; i >= 1; i--) {
            dfs(n - i * i, count + 1);
        }
    }
}

// time: O(100^n); space: O(1);
