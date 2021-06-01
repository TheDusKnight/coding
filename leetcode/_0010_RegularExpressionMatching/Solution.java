package leetcode._0010_RegularExpressionMatching;

public class Solution {
    public static boolean isMatch(String s, String p) {
        // 注意s和p长度都可以是0
        if (s == null || p == null)
            return false;
        return dfs(s, 0, p, 0);
    }
    
    private static boolean dfs(String s, int idxS, String p, int idxP) {
        int sLen = s.length(), pLen = p.length();
        // 注意s到头p有可能不到头但依然valid，比如s="", p="a*"，但p到头s必须到头才算valid
        if (idxP == pLen) {
            return idxS == sLen;
        }
        if (idxP+1 == pLen || p.charAt(idxP+1) != '*') { // 非星结构没有分叉
            if (idxS < sLen && isMatch(s, idxS, p, idxP)) {
                return dfs(s, idxS+1, p, idxP+1);
            } else {
                return false;
            }
        } else {
            // 星结构第一次可以不match任何string，i下一层从idxS位置开始
            int i = idxS-1;
            // 当i == idxS-1不需要match
            while (i < sLen && (i == idxS-1 || isMatch(s, i, p, idxP))) {
                if (dfs(s, i+1, p, idxP+2)) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
    
    private static boolean isMatch(String s, int idxS, String p, int idxP) {
        if (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab"; // aab, aab, aa
        String p = "a*a"; // a*bb, a*aa or a*a, a*a
        System.out.println(isMatch(s, p));
    }
}

// time: O(m^n) 一个a*分m个叉，一共n层高
// s = "aaaa...ab" O(m)
// p = "a*a*a*...a*" O(n)