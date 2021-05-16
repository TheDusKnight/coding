package leetcode._0231_PowerOfTwo;

// recursion
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) return true;
        if (n <= 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n/2);
    }
}
