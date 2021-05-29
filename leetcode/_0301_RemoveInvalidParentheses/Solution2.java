package leetcode._0301_RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // dfs List version, 出现duplicate的原因是出现了连续的括号，所有要用subset II的方法只保留连续括号的第一个prefix
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0)
            return res;
        
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                rmL++;
            else if (s.charAt(i) == ')') {
                if (rmL > 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        dfs(res, s, new StringBuilder(), 0, rmL, rmR, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder path, int idx, int rmL, int rmR, int delta) {
        int pLen = path.length();
        int sLen = s.length();
        if (idx == sLen && rmL == 0 && rmR == 0 && delta == 0) {
            res.add(path.toString());
            return;
        }
        if (idx >= sLen || rmL < 0 || rmR < 0 || delta < 0)
            return;
        
        char cur = s.charAt(idx);
        int i = idx;
        if (cur == '(') {
            while (i < s.length() && s.charAt(i) == '(')
                i++;
            path.append(s.substring(idx, i));
            dfs(res, s, path, i, rmL, rmR, delta+i-idx);
            path.setLength(pLen);
            dfs(res, s, path, idx+1, rmL-1, rmR, delta);
        } else if (cur == ')') {
            while (i < s.length() && s.charAt(i) == ')')
                i++;
            path.append(s.substring(idx, i));
            dfs(res, s, path, i, rmL, rmR, delta-(i-idx));
            path.setLength(pLen);
            dfs(res, s, path, idx+1, rmL, rmR-1, delta);
        } else {
            path.append(cur);
            dfs(res, s, path, idx+1, rmL, rmR, delta);
            path.setLength(pLen);
        }
    }
}

// time: O(2^n) constant factor级别优化

// follow up: Any valid Parentheses sequence?
// 扫两遍：remove all ')', which cause delta < 0， delta = left - right; remove all '(', which cause delta < 0, delta = right - left; （该方法只能用于找一个解）,time O(n), space O(1)x