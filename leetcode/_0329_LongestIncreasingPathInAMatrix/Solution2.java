package leetcode._0329_LongestIncreasingPathInAMatrix;

class Solution2 {
    int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return -1;
        int res = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (i < 0 || i > matrix.length || j < 0 || j > matrix[0].length ) {
            return 0;
        }
        if (memo[i][j] > 0)
            return memo[i][j];

        int max = 0;
        for (int[] dir: DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < matrix.length && jj >= 00 && jj < matrix[0].length && matrix[ii][jj] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, ii, jj, memo));
            }
        }
        memo[i][j] = max+1;
        return max+1;
    }
}

// time: O(m*n) amortized cost, first dfs O(m*n), after all dfs O(1)