package leetcode._0392_IsSubsequence;

// array two pointers
class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) throw new IllegalArgumentException();
        if (s.length() == 0) return true;
        if (s.length() == 0) return false;
        
        int sIdx = 0, sLen = s.length(), tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            if (s.charAt(sIdx) == t.charAt(i)) sIdx++;
            if (sIdx == sLen) break;
        }
        
        return sIdx == sLen;
    }
}

// time: O(tLen); space: O(1);
