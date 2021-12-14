package leetcode._0093_RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

// dfs 比 word break难
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 255)
            return res;
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, String s, StringBuilder path, int idx, int num) {
        int sLen = s.length();
        int pLen = path.length();
        if (num == 4) { // 忘记数字是4
            if (idx == sLen) {
                path.deleteCharAt(pLen-1);
                res.add(path.toString());
            }
            return;
        }
        if (idx >= sLen)
            return;
        
        for (int l = 1; l <= 3; l++) {
            // idx+l = length of current path
            if (idx+l > sLen) break; // 忘记break
            int val = Integer.parseInt(s.substring(idx, idx+l));
            if (val <= 255) {
                path.append(val + ".");
                dfs(res, s, path, idx+l, num+1);
                path.setLength(pLen);
            }
            // 当val为0时，只能走"0."分支，0后面不能接任何东西
            if (val == 0) break;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses("25525511135"));
    }
}

// time: O(2^12) = O(1); space: O(1)
