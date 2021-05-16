package jianzhioffer.array._04;

/**
 * 二维数组中的查找
 */
// 线性查找
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        
        int row = matrix.length, col = matrix[0].length;
        int i = 0, j = col-1;
        while (i <= row -1 && j >= 0) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            }
            if (cur > target) {
                // cur become smaller
                j--;
            } else {
                // cur become bigger
                i++;
            }
        }
        return false;
        // return matrix[i][j] == target ? true : false;
    }
}

// time: O(n+m); space: O(1);