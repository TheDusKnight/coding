package leetcode._0048_RotateImage;

// Math高频
class Solution {
    public void rotate(int[][] matrix) {
        // cc

        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) { // odd时，i到中点
            for (int j = 0; j < n / 2; j++) { // odd时，j到中点减1
                int tmp = matrix[n - 1 - j][i]; // 左下
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // 右下
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // 右上
                matrix[j][n - 1 - i] = matrix[i][j]; // 左上
                matrix[i][j] = tmp; // 左下赋值左上
            }
        }
    }
}