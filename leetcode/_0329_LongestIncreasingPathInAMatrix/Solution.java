package leetcode._0329_LongestIncreasingPathInAMatrix;

class Solution {
    // dfs 无环 无pruning超时
    int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }

        int max = 0;
        for (int[] dir : DIRECTIONS) {
            int ii = i + dir[0];
            int jj = j + dir[1];
            if (ii >= 0 && ii < matrix.length && jj >= 0 && jj < matrix[0].length && matrix[ii][jj] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, ii, jj));
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        Solution sol = new Solution();
        System.out.println(sol.longestIncreasingPath(input));
    }
}

// time: O(2^(m+n)*(m*n)) = O(2^(m+n))
