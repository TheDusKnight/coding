package leetcode._0022_GenerateParentheses;
import java.util.ArrayList;
import java.util.List;

// 算法哥dfs
class Solution {
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
        // 算法哥不成功的情况在下一层阻止，老刘在前一层阻止
        if (l < 0 || r < l) return; // 左边加超过n或者右边加超过左边都fail
        
        // 老刘 if (l > 0)
        sb.append('(');
        dfs(res, l-1, r, sb);
        sb.setLength(sb.length()-1); // remove(), setLength, deleteCharAt()
        
        // 老刘 if (r > l)
        sb.append(')');
        dfs(res, l, r-1, sb);
        sb.setLength(sb.length()-1);
    }
}
// time: O(2^n)