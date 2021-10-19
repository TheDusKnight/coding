package leetcode._0694_NumberOfDistinctlands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs改变board实现visited
class Solution2 {
    int row, col;
    int originalRow, originalCol;
    Set<List> res;
    int[][] grid;
    List<List> list;
    public int numDistinctIslands(int[][] grid) {
        // cc
        
        this.grid = grid;
        row = grid.length; col = grid[0].length;
        res = new HashSet<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    originalRow = i;
                    originalCol = j;
                    list = new ArrayList<>();
                    dfs(i, j);
                    res.add(list);
                }
            }
        }
        
        return res.size();
    }
    
    private void dfs(int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col || grid[r][c] != 1) {
            return;
        }
        
        list.add(Arrays.asList(r - originalRow, c - originalCol));
        grid[r][c] = 0;
        
        dfs(r+1, c);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r, c-1);
    }
}

// time: O(m*n); space: O(m*n);
