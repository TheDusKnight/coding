package leetcode._0069_Sqrtx;

// binary search
class Solution {
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException();
        if (x < 1) return 0;
        if (x < 4) return 1;
        
        int left = 1, right = Integer.MAX_VALUE, mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (mid == (x / mid)) return mid;
            else if (mid > (x / mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        return (right <= (x / right)) ? right : left;
    }
}
