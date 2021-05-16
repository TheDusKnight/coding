package leetcode._0120_Triangle;
import java.util.*;

// dfs
// 计算所有path的长度
public class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = dfs(triangle, 0, 0, 0);
        return res;
    }

    private int dfs(List<List<Integer>> triangle, int i, int j, int sol) {
        sol += triangle.get(i).get(j);
        // 答案出在leaf node
        if (i == triangle.size()-1) return sol;

        // 不需要回溯
        int left = dfs(triangle, i+1, j, sol);
        int right = dfs(triangle, i+1, j+1, sol);
        return Math.min(left, right);
    }
}

// time: O(2^n)