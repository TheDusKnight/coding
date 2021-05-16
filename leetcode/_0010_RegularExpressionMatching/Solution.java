package leetcode._0010_RegularExpressionMatching;

// 看算法哥课上
// 非常巧妙的一道题，重点是else
public class Solution {
    public static void main(String[] args) {
        String s = "ab"; // aab, aab, aa
        String p = "a*a"; // a*bb, a*aa or a*a, a*a
        System.out.println(isMatch(s, p));
    }
    
    public static boolean isMatch(String s, String p) { // no pruning
        if (s == null || p == null) return false;
        return helper(s, 0, p, 0);
    }
    // lenP和lenS提出来？
    private static boolean helper(String s, int idxS, String p, int idxP) {
        int lenP = p.length(), lenS = s.length();

        if (idxP == lenP) {
            return idxS == lenS;
        } else if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*') {
            if (idxS < lenS && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))) {
                return helper(s, idxS + 1, p, idxP + 1);
            } else {
                return false;
            }
        } else {
            int i = idxS - 1; // 如果i是0，那i + 1就漏掉0了
            while (i < lenS && (i < idxS || p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(i))) {
                if (helper(s, i + 1, p, idxP + 2)) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
