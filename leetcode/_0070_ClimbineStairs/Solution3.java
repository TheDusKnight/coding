package leetcode._0070_ClimbineStairs;

// DP
class Solution3 {
    public int climbStairs(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        if (n <= 2) return n;
        int first = 1, second = 2, curr = 3, tmp;
        for (int i = 3; i <= n; i++) {
            curr = first + second;
            tmp = second;
            second = curr;
            first = tmp;
        }
        return curr;
    }
}