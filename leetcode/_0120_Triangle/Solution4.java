package leetcode._0120_Triangle;
import java.util.*;

// recursion 计划存储
class Solution4 {
    // 注意dp array有可能是任何值所以check时通过null判断是否填过值
    Integer[][] dp = new Integer[200][200];
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = helper(triangle, 0, 0);
        return res;
    }
    
    private int helper(List<List<Integer>> triangle, int i, int j) {
        // base case
        if (i == triangle.size()-1) {
            return triangle.get(i).get(j);
        }
        // dp check
        if (dp[i][j] != null) return dp[i][j];
        int left = helper(triangle, i+1, j);
        int right = helper(triangle, i+1, j+1);

        int curVal = Math.min(left, right) + triangle.get(i).get(j);
        // dp 填值
        dp[i][j] = curVal;
        return curVal;
    }
}
// time: O(n^2) 一共n层，n^2个node