package leetcode._0231_PowerOfTwo;

// math
class Solution5 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // find max power of 2 in int;
        int max = (int) Math.pow(2, 30);
        if (max % n != 0) return false;
        return true;
    }
}
