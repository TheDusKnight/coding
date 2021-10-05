package leetcode._0062_UniquePaths;

// recursion
class Solution2 {
    int m;
    int n;
    public int uniquePaths(int m, int n) {
        
        this.m = m;
        this.n = n;
        int[][] memo = new int[m][n];
        return recursion(0, 0, memo);
    }
    
    private int recursion(int i, int j, int[][] memo) {
        if (i == m-1 && j == n-1) {
            return 1;
        }
        if (i > m-1 || j > n-1) {
            return 0;
        }
        
        if (memo[i][j] != 0) return memo[i][j];
        
        int right = recursion(i, j+1, memo);
        int down = recursion(i+1, j, memo);
        
        memo[i][j] = right + down;
        return memo[i][j];
    }
}

// time: O(m*n); space: O(m*n);}
