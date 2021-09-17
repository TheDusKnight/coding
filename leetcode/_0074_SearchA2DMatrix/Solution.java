package leetcode._0074_SearchA2DMatrix;

// binary search dfs写法
class Solution {
    int[][] matrix;
    int target;
    int col;
    int row;
    public boolean searchMatrix(int[][] matrix, int target) {
        // cc
        
        this.matrix = matrix;
        this.target = target;
        this.row = matrix.length;
        this.col = matrix[0].length;
        
        int l = 0 * col + 0, r = (row-1) * col + (col-1);
        return binarySearch(l, r);
    }
    
    private boolean binarySearch(int l, int r) {
        if (l > r) return false;
        
        int mid = l + (r - l) / 2;
        int midRow = mid / col, midCol = mid % col;
        
        if (matrix[midRow][midCol] == target) return true;
        else if (matrix[midRow][midCol] < target) return binarySearch(mid+1, r);
        else return binarySearch(l, mid-1);
        
    }
}

// time: O(log(N)); space: O(log(N)) stack
