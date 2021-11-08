package leetcode._0069_Sqrtx;

// binary search
class Solution2 {
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException();
        if (x <= 1) return x;
        
        int l = 1, r = x/2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) l = mid+1;
            else r = mid-1;
        }
        
        return r;
    }
}

// time: O(log(N)); space: O(1)
// follow-up: 保留小数点后两位? input乘以一万，output除以100以string形式输出
