package jianzhioffer.recursionDp._10;

/**
 * 斐波那契数列
 */

 // 计划存储recursion
public class Solution {
    int[] dp = new int[100];
    public int fib(int n) {
        if (n <= 1) return n;

        int left, right;
        if (dp[n-1] != 0) {
            left = dp[n-1];
        } else {
            left = fib(n-1);
            dp[n-1] = left;
        }
        if (dp[n-2] != 0) {
            right = dp[n-2];
        } else {
            right = fib(n-2);
            dp[n-2] = right;
        }
        return (left + right) % 1000000007;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(80));
    }
}

// time: O(n), 每个节点最多计算一次; space: O(n)
