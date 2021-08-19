package leetcode._0070_ClimbineStairs;

// recursion -> memoization -> dp with O(n) space -> dp with O(1) space -> dp with O(0) inplace
class Solution {
    public int climbStairs(int n) {
        // cc
        
        if (n == 1 || n == 2) return n;
        
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
