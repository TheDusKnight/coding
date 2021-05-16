package leetcode._0022_GenerateParentheses;
import java.util.*;

// 老刘dfs
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) return res; // 讨论
        
        dfs(n, n, new StringBuilder(), res);
        return res;
    }
    
    private void dfs(int left, int right, StringBuilder sb, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        
        // 算法哥不成功的情况check, left == right 是可以的因为left还可以减少
        // if (left > right || left < 0) return;
        
        if (left > 0) {
            sb.append('(');
            dfs(left-1, right, sb, res);
            sb.setLength(sb.length()-1); // remove(), setLength, deleteCharAt()
        }
        
        // 老刘进入条件check
        if (right > left) { // 可以不加right > 0 因为left已经大于0了
            sb.append(')');
            dfs(left, right-1, sb, res);
            sb.setLength(sb.length()-1);
        }
    }
}