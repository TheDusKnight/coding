package leetcode._0190_ReverseBits;

// 新建一个int，从n尾巴读值赋值到新int头部，单边访问,神龙摆尾
public class Solution {
    // you need to treat n as a unsigned value
    public int reverseBits(int n) {
        // cc all 0
        if (n == 0) return n;

        int res = 0;
        int tmp;
        for (int i = 0; i < 32; i++) {
            // 找到第i位的值
            tmp = (n >> i & 1);
            res |= tmp << (31 - i); // 32位，31长度到最后一位
        }
        return res;
    }
}
