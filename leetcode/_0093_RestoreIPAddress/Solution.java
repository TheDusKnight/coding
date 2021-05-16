package leetcode._0093_RestoreIPAddress;
import java.util.*;

// dfs 做或不做模版
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, String s, StringBuilder sb, int index, int part) {
        if (index == s.length() && part == 4) {
            sb.setLength(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        if (index == s.length()) return;
        
        int len = sb.length();
        for (int l = 1; l <= 3; l++) {
            if (index+l <= s.length()) {
                int cur = Integer.valueOf(s.substring(index, index+l));
                if (cur >= 0 && cur <= 255) {
                    sb.append(cur + ".");
                    dfs(res, s, sb, index+l, part+1);
                    sb.setLength(len);
                }
                // if cur part start with 0, then this branch can not be continue
                if (cur == 0) break;
            }
        }
    }
}
