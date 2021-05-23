package leetcode._0064_MinimumPathSum;

public class Solution2 {
    // 两个1d dp
    public int minPathSum(int[][] grid) {
        // cc

        int row = grid.length;
        int col = grid[0].length;
        int[] pre = new int[col];
        pre[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            pre[i] = pre[i-1] + grid[0][i];
        }
        
        int[] cur = new int[col];
        for (int i = 1; i < row; i++) {
            cur[0] = pre[0] + grid[i][0];
            for (int j = 1; j < col; j++) {
                cur[j] = Math.min(pre[j] + grid[i][j], cur[j-1] + grid[i][j]);
            }
            pre = cur;
        }
        return pre[col-1];
    }
    // time: O(m*n); space: O(2n);

    // 一个1d dp
    public int minPathSum2(int[][] grid) {
        // cc
        if (grid.length <= 0 || grid[0].length <= 0)
            return -1;

        int row = grid.length;
        int col = grid[0].length;
        int[] pre = new int[col];
        pre[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            pre[i] = pre[i-1] + grid[0][i];
        }

        int left;
        int cur = pre[col-1]; // 防止无法进入loop也就是row只有一层的情况
        for (int i = 1; i < row; i++) {
            left = pre[0] + grid[i][0];
            for (int j = 1; j < col; j++) {
                cur = Math.min(pre[j] + grid[i][j], left + grid[i][j]);
                pre[j-1] = left;
                left = cur;
            }
            pre[col-1] = left;
        }
        return cur;
    }
    // time: O(m*n); space: O(n);

    // inplace dp
    public int minPathSum3(int[][] grid) {
        // cc
        if (grid.length <= 0 || grid[0].length <= 0)
            return -1;
        
        int row = grid.length, col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = grid[i][j];
                } else if (i == 0) {
                    grid[i][j] += grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] += grid[i-1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        return grid[row-1][col-1];
    }
    // time: O(m*n); space: O(1);

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[][] input = {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(sol.minPathSum3(input));
    }
}
