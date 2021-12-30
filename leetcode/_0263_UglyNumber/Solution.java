package leetcode._0263_UglyNumber;

// math
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        
        int[] factors = new int[] {2,3,5};
        for (int factor: factors) {
            while (n % factor == 0) {
                n /= factor; // 根据丑数定义不断除factor直到没法除为止
            }
        }
        
        return n == 1;
    }
}

// time: O(log(N)); space: O(1);
