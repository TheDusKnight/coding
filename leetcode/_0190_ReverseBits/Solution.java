package leetcode._0190_ReverseBits;

// 新建一个int， 从n尾巴访问
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return n;
        
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int cur = n & 1;
            n >>>= 1;
            
            res = res ^ (cur << i);
        }
        
        return res;
    }
}

// time: O(N); space: O(1);
