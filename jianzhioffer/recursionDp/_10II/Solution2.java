package jianzhioffer.recursionDp._10II;

// 零维dp
public class Solution2 {
    public int numWays(int n) {
        if (n <= 1) return 1;

        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
