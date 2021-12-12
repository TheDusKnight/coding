package leetcode._0007_ReverseInteger;

// LC190 Reverse Bits的另一种版本
public class Solution {
    public int reverse(int x) {
        // cc
        if (x < 10 && x >= 0) return x;
        
        int res = 0;
        while (x != 0) { // 写成了 x > 0
            // overflow?
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && x % 10 > 7)) return 0;
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && x % 10 < -8)) return 0;
            res = res * 10 + x % 10; // res = res << 1 + n & 1
            x /= 10; // java api负数可以应对
            // n >>= 1
        }
        return res;
    }
}
