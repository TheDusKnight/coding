package leetcode._0072_EditDistance;

import java.util.Arrays;

public class Solution {
    // dfs + pruning
    public int minDistance(String word1, String word2) {
        // 注意word1和word2可以length为0
        if (word1 == null || word2 == null)
            return -1;

        int[][] memo = new int[word1.length()][word2.length()];
        // 值不能初始化为0，因为0代表index之前完全匹配
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(word1, word2, word1.length()-1, word2.length()-1, memo);
    }

    private int dfs(String word1, String word2, int i, int j, int[][]memo) {
        if (i == -1) 
            return j+1;
        if (j == -1)
            return i+1;
        if (memo[i][j] != -1)
            return memo[i][j];
        
        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        if (c1 == c2) {
            memo[i][j] = dfs(word1, word2, i-1, j-1, memo);
        } else {
            int replace = dfs(word1, word2, i-1, j-1, memo) + 1;
            int insert = dfs(word1, word2, i, j-1, memo) + 1;
            int delete = dfs(word1, word2, i-1, j, memo) + 1;
            memo[i][j] = Math.min(replace, Math.min(insert, delete));
        }
        return memo[i][j];
    }
}
