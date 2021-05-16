package leetcode._0022_GenerateParentheses;
import java.util.*;

// 算法哥dfs
class Solution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res;
        
        dfs(res, n, n, new StringBuilder());
        return res;
    }
    
    // 不需要set visited因为是图没有环
    private void dfs(List<String> res, int l, int r, StringBuilder sb) {
        // success
        if (l == 0 && r == 0) { // 最终每个res的长度为2n并且l = r
            res.add(sb.toString());
            return;
        }
        // fail
        if (l < 0 || r < l) return; // 左边加超过n或者右边加超过左边都fail
        
        sb.append('(');
        dfs(res, l-1, r, sb);
        sb.setLength(sb.length()-1);
        
        sb.append(')');
        dfs(res, l, r-1, sb);
        sb.setLength(sb.length()-1);
    }
}