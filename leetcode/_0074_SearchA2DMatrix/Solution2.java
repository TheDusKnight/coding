package leetcode._0074_SearchA2DMatrix;

// binary search in 2d Matrix
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = (row-1) * col + (col-1);
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / col, j = mid % col;
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) left = mid+1;
            else right = mid-1;
        }
        
        return false;
    }
}

// time: O(log(N)); space: O(1);
