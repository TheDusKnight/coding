package leetcode._0191_NumberOf1Bits;

// bit
// input右移
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // cc
        
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n >> i) & 1;
        }
        
        return count;
    }
}