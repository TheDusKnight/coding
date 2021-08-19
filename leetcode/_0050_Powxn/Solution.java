package leetcode._0050_Powxn;

// math + recursion with binary reduction
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        
        long N = n; // 将int变成long否则有test case过不去
        if (N < 0) { // check负数情况
            N = -N;
            x = 1 / x;
        }
        
        return pow(x, N);
    }
    
    private double pow(double x, long n) {
        if (n == 1) return x;
        
        double tmp = pow(x, n/2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
}

// time: O(log(n));
