package leetcode._0069_Sqrtx;

// brute force
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int res = 1;
        for (int i = 1; i <= x/2; i++) {
            if (i * i <= x) res = i;
            else break;
        }
        
        return res;
    }
}
