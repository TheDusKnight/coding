package leetcode._0022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution3 {
    // dfs + delta, 时间复杂度小，Memory Usage 最优
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0)
            return res;
        dfs(res, new StringBuilder(), n, 0);
        return res;
    }
    
    private void dfs(List<String> res, StringBuilder path, int n, int delta) {
        if (path.length() == 2*n) {
            if (delta == 0) {
                res.add(path.toString());
            }
            return;
        }
        if (delta < 0)
            return;
        
        int len = path.length();
        path.append('(');
        dfs(res, path, n, delta+1);
        path.setLength(len);
        
        path.append(')');
        dfs(res, path, n, delta-1);
        path.setLength(len);
    }
}
// time: O(2^n)，常数级别优化