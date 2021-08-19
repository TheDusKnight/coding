package leetcode._0070_ClimbineStairs;

// recursion -> memoization -> dp with O(n) space -> dp with O(1) space -> dp with O(0) inplace
class Solution2 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        
        int[] memo = new int[n];
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n, int[] memo) {
        if (n == 1 || n == 2) return n;
        
        int one, two;
        if (memo[n-1] != 0) one = memo[n-1];
        else {
            one = climbStairs(n-1, memo);
            memo[n-1] = one;
        }
        if (memo[n-2] != 0) two = memo[n-2];
        else {
            two =climbStairs(n-2, memo);
            memo[n-2] = two;
        }
        
        return one + two;
    }
}
