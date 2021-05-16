package leetcode._0120_Triangle;
import java.util.*;

// Solution2 improve, 使用global min记录最短路径避免向上传递
class Solution3 {
    int min = Integer.MAX_VALUE;
    public int minimumTotal(List<List<Integer>> triangle) {
        dfs(triangle, 0, 0, 0);
        return min;
    }
    
    private void dfs(List<List<Integer>> triangle, int i, int j, int sum) {
        // 答案出在lead node，min更新最小path
        if (i == triangle.size()-1) {
            sum += triangle.get(i).get(j);
            min = Math.min(sum, min);
            return;
        }
        
        int curVal = triangle.get(i).get(j);
        dfs(triangle, i+1, j, sum + curVal);
        dfs(triangle, i+1, j+1, sum + curVal);
    }
}