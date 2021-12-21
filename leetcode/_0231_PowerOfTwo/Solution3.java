package leetcode._0231_PowerOfTwo;

// bit operation, Hamming weight
class Solution3 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & mask) == 1) count++;
            if (count > 1) return false;
        }
        return true;
    }
}
