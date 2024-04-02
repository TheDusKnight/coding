package leetcode._0205_IsomorphicStrings;
// https://leetcode.com/problems/isomorphic-strings/solutions/4960160/beats-99-easiest-code-with-comments-explained-beginner-friendly
public class Solution2 {
    public boolean isIsomorphic(String s, String t) {
        int[] freqS = new int[256];
        int[] freqT = new int[256];

        int len = s.length();
        if (len != t.length()) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            char sCur = s.charAt(i);
            char tCur = t.charAt(i);

            if (freqS[sCur] != freqT[tCur]) {
                return false;
            }
            freqS[sCur] = i + 1;
            freqT[tCur] = i + 1;
        }

        return true;
    }
}
