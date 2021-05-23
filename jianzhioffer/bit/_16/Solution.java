package jianzhioffer.bit._16;

/**
 * 二进制中1的个数 same: lc50
 */

 // Brute force
class Solution {
    public double myPow(double x, int n) {
        long N = n; // 记住负数int比整数int范围大一
        if (N < 0) { // 如果N为负数
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans *= x;
        }
        return ans;
    }
}

// time: O(n); space: O(1)
