package leetcode._0231_PowerOfTwo;

// while loop
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        
        while (n != 1) {
            if (n % 2 == 1) return false;
            n /= 2;
        }
        
        return true;
    }
}

// time: O(log(N)); space: O(1);