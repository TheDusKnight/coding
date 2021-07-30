package leetcode._0694_NumberOfDistinctlands;

import java.util.HashSet;
import java.util.Set;

import leetcode.Pair;

public class Solution {
    private int[][] grid;
    private boolean[][] seen;
    private Set<Pair> currIsland;
    private int originRow;
    private int originCol;

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        this.grid = grid;
        seen = new boolean[this.grid.length][this.grid[0].length];
        Set<Set> res = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    currIsland = new HashSet<>();
                    originRow = i;
                    originCol = j;
                    dfs(i, j);
                    if (!currIsland.isEmpty()) {
                        res.add(currIsland);
                    }
                }
            }
        }
        return res.size();
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || seen[i][j])
            return;

        seen[i][j] = true;
        currIsland.add(new Pair<Integer, Integer>(i - originRow, j - originCol));
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}

// time: O(n*m). n is length, m is hight; space: O(n*m) for seen