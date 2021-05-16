package leetcode._0301_RemoveInvalidParentheses;
import java.util.*;

// dfs HashSet version 无优化
public class Solution {
    private void dfs(Set<String> set, String s, int i, int rmL, int rmR, int delta, StringBuilder sb) {
        // if success
        if (i == s.length() && rmL == 0 && rmR == 0 && delta == 0) {
            set.add(sb.toString());
            return;
        }
        // if fail
        if (i >= s.length() || rmL < 0 || rmR < 0 || delta < 0) return;

        // 不需要for loop，每次两个叉
        char c = s.charAt(i);
        if (c == '(') {
            // remove '('
            dfs(set, s, i + 1, rmL - 1, rmR, delta, sb);
            // keep '('
            sb.append('(');
            dfs(set, s, i + 1, rmL, rmR, delta + 1, sb);
            sb.setLength(sb.length() - 1);
        } else if (c == ')') {
            // remove ')'
            dfs(set, s, i + 1, rmL, rmR - 1, delta, sb);
            // keep ')'
            sb.append(')');
            dfs(set, s, i + 1, rmL, rmR, delta - 1, sb);
            sb.setLength(sb.length() - 1);
        } else {
            sb.append(c);
            dfs(set, s, i + 1, rmL, rmR, delta, sb);
            sb.setLength(sb.length() - 1);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>();
        int rmL = 0, rmR = 0;
        for (char c : s.toCharArray()) {
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
        dfs(set, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(set);
    }
}
