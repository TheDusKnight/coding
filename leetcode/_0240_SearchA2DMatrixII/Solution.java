package leetcode._0240_SearchA2DMatrixII;

// This is not a binary search, but uses some principles from binary search
// 从左下往右或者上找target
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // cc
        
        int row = matrix.length;
        int col = matrix[0].length;
        int rIdx = row-1, cIdx = 0;
        
        while (rIdx >= 0 && cIdx < col) {
            int curVal = matrix[rIdx][cIdx];
            if (curVal == target) return true;
            else if (curVal < target) cIdx++;
            else rIdx--;
        }
        
        return false;
    }
}

// time: O(m+n); space: O(1)
