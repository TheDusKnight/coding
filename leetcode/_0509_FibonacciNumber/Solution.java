package leetcode._0509_FibonacciNumber;

// recursion
class Solution {
    public int fib(int N) {
        // base case
        if (N < 0) throw new IllegalArgumentException();
        if (N == 1) return 1;
        if (N == 0) return 0;
        
        return fib(N-1) + fib(N-2);
    }
}
// time: O(2^n)
// space: O(N) 系统栈的消耗