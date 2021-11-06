package leetcode._0441_ArrangingCoins;

// binary search

class Solution2 {
    public int arrangeCoins(int n) {
        // cc
        
        long left = 1, right = n;
        
        while (left <= right) {
            long k = left + (right - left) / 2;
            long cal = (k*(k+1)) / 2;
            if (cal == n) return (int)k;
            else if (cal > n) right = k-1;
            else left = k+1;
        }
        
        return (int)right; // n 的左边是right，右边是left
    }
}

// time: O(log(N)); space: O(1);
