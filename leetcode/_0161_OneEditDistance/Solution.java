package leetcode._0161_OneEditDistance;

// abcde abcxde; abcxde abcde; abcxd abcyd;
// abc abcx; abcx abc; abc abc -> false;
// 注意pre-processing和post-processing
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        
        int sLen = s.length(), tLen = t.length();
        for (int i = 0; i < Math.min(sLen, tLen); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLen == tLen) {
                    // return s.substring(i+1).equals(t.substring(i+1));
                    return checkSubstring(s, t, i+1, i+1);
                } else if (sLen < tLen) {
                    // return s.substring(i).equals(t.substring(i+1));
                    return checkSubstring(s, t, i, i+1);
                } else {
                    // return s.substring(i+1).equals(t.substring(i));
                    return checkSubstring(s, t, i+1, i);
                }
            }
        }
        
        return sLen != tLen ? true : false;
    }
    
    // substring可以被双指针代替
    private boolean checkSubstring(String s, String t, int i, int j) {
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) return false;
            i++;
            j++;
        }
        return true;
    }
}

// time: O(Math.min(M, N)); space: O(Math.min(M, N));