package leetcode._0240_SearchA2DMatrixII;

// This is not a binary search, but uses some principles from binary search
// 从左下往右或者上找target
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length;
        int i = row-1, j = 0;
        
        while (i >= 0 && j < col) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) j++;
            else i--;
        }
        
        return false;
    }
}

// time: O(m+n); space: O(1);
