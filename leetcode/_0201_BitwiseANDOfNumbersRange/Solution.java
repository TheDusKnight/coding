package leetcode._0201_BitwiseANDOfNumbersRange;

// bit brute force
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // cc
        
        int res = left;
        for (int i = left+1; i <= right; i++) {
            res &= i;
        }
        
        return res;
    }
}

// time: O(N); space: O(1);
