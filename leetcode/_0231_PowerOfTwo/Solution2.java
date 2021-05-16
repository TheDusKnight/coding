package leetcode._0231_PowerOfTwo;

// 反向binary search, 从下到大考虑
class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        long a = 1;
        while (a <= n) {
            if (a == n) return true;
            a *= 2;
        }
        return false;
    }
}