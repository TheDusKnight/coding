package leetcode._0231_PowerOfTwo;

// while loop
class Solution3 {
    public boolean isPowerOfTwo(int n) {
        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return n == 1;
    }
}
