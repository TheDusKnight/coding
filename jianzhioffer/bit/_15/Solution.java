package jianzhioffer.bit._15;

/**
 * 二进制中1的个数 same lc191
 */

 // input 右移
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            // 结果要么是1要么是0
            if ((n >> i & mask) == 1) count++;
        }
        return count;
    }
}

// time: O(1); space: O(1)