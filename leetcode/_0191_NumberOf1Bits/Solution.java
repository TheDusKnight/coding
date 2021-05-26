package leetcode._0191_NumberOf1Bits;

// bit
// input右移
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & mask) == 1) count++; // n >>> i
            // n >>= 1;
        }
        return count;
    }
}