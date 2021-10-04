package leetcode._0070_ClimbineStairs;

// recursion计划存储
class Solution2 {
    public int climbStairs(int n) {
        if (n < 1) throw new IllegalArgumentException();
        
        int[] memo = new int[n+1];
        return recursion(n, memo);
    }
    
    private int recursion(int n, int[] memo) {
        if (n == 1 || n == 2) return n;
        
        if (memo[n] != 0) return memo[n];
        
        int fromOne = recursion(n-1, memo);
        int fromTwo = recursion(n-2, memo);
        memo[n-1] = fromOne;
        memo[n-2] = fromTwo;
        
        return fromOne + fromTwo;
    }
}

// time: O(N); space: O(N);
