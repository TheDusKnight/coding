package leetcode._0059_SpiralMatrixII;

// recursion
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) return null;
        int[][] res = new int[n][n];

        int size = n;
        int num = 1;
        generate(res, 0, size, num);
        return res;
    }

    private void generate(int[][] res, int offset, int size, int num) {
        if (size == 0) return;
        if (size == 1) {
            res[offset][offset] = num;
            return;
        }

        for (int i = 0; i < size-1; i++) {
            res[offset][offset+i] = num++;
        }
        for (int i = 0; i < size-1; i++) {
            res[offset+i][offset+size-1] = num++;
        }
        for (int i = 0; i < size-1; i++) {
            res[offset+size-1][offset+size-1-i] = num++;
        }
        for (int i = 0; i < size-1; i++) {
            res[offset+size-1-i][offset] = num++;
        }

        generate(res, offset+1, size-2, num);
    }
}
