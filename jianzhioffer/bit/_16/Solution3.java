package jianzhioffer.bit._16;

// fast power iteration (normal / bit)
public class Solution3 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long N = n;
        double res = 1.0;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        while (N > 0) {
            if ((N & 1) == 1) res *= x;
            // if ((N % 2) == 1) res *= x;
            x *= x;
            N >>= 1;
            // N /= 2;
        }
        return res;
    }
}

// time: O(log(n)); space: O(1)