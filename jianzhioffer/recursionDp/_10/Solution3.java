package jianzhioffer.recursionDp._10;

// 零位dp
public class Solution3 {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            // 运行了n次，第一次的sum是f(2), n为2时运行2次，第二次sum为f(3),a为f(2)
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.fib(50));
    }
}

// time: O(n); space: O(1)
