package leetcode._0231_PowerOfTwo;

// bit, 减1取且操作
// 0000 1000
// 0000 0111
class Solution4 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        
        int n_ = n - 1;
        if ((n_ & n) == 0) return true;
        return false;
    }
}
