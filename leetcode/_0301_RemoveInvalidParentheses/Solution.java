package leetcode._0301_RemoveInvalidParentheses;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    // dfs HashSet version 无优化
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> res = new HashSet<>();
        if (s == null || s.length() == 0)
            return new ArrayList<String>();
        int rmL = 0, rmR = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                rmL++;
            } else if (c == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        dfs(res, s, new StringBuilder(), 0, rmL, rmR, 0);
        return new ArrayList<String>(res);
    }
    
    private void dfs(Set<String> res, String s, StringBuilder path, int idx, int rmL, int rmR, int delta) {
        int sLen = s.length();
        int pLen = path.length();
        if (idx == sLen && rmL == 0 && rmR == 0 && delta == 0) {
            res.add(path.toString());
            return;
        }
        // 注意>=
        if (idx >= sLen || rmL < 0 || rmR < 0 || delta < 0)
            return;
        
        // 不需要for loop,每次分两个叉!
        char cur = s.charAt(idx);
        if (cur == '(') {
            dfs(res, s, path, idx+1, rmL-1, rmR, delta);
            path.append('(');
            dfs(res, s, path, idx+1, rmL, rmR, delta+1);
            path.setLength(pLen);
        } else if (cur == ')') {
            dfs(res, s, path, idx+1, rmL, rmR-1, delta);
            path.append(')');
            dfs(res, s, path, idx+1, rmL, rmR, delta-1);
            path.setLength(pLen);
        } else {
            // 只有一条路径就是加letter
            path.append(cur);
            dfs(res, s, path, idx+1, rmL, rmR, delta);
            path.setLength(pLen);
        }
    }
}