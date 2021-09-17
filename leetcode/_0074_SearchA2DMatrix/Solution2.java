package leetcode._0074_SearchA2DMatrix;

// binary search iteration写法
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // cc
        
        int row = matrix.length, col = matrix[0].length;
        int l = 0 * col + 0, r = (row-1) * col + (col-1);
        
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midRow = mid / col, midCol = mid % col;
            if (matrix[midRow][midCol] == target) return true;
            else if (matrix[midRow][midCol] < target) l = mid+1;
            else r = mid-1;
        }
        return false;
    }
}

// time: O(log(N)); space: O(1)
