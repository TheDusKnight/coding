package jianzhioffer.bit._16;

// fast power recursion
// https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/mian-shi-ti-16-shu-zhi-de-zheng-shu-ci-fang-kuai-s/
class Solution2 {
    public double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) { // if even
            return half * half;
        } else { // if odd, then x^n = x*x^(n//2)*x^(n//2)
            return half * half * x;
        }
    }
    public double myPow(double x, int n) {
        if (x == 0) return 0;

        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        return fastPow(x, N);
    }
}

// time: O(log(n)); space: O(log(n))