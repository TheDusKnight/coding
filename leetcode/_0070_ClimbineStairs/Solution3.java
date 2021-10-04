package leetcode._0070_ClimbineStairs;

// dp inplace
class Solution3 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        
        int one = 1, two = 2, three = 3;
        for (int i = 3; i <= n; i++) {
            three = one + two;
            one = two;
            two = three;
        }
        
        return three;
    }
}

// time: O(N); space: O(1);