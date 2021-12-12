package leetcode._0190_ReverseBits;

// 双指针swap
public class Solution2 {
    public int reverseBits(int n) {
        // cc
        if (n == 0) return n;

        for (int i = 0; i < 16; i++) {
            int left = 1 & (n >> (31 - i));
            int right = 1 & (n >> i);

            if (left != right) { // 重点通过左右是否相等反转0和1
                n ^= 1 << (31 - i);
                n ^= 1 << i;
            }
        }
        return n;
    }
}
