package leetcode._0028_ImplementstrStr;

// Robin - Karb sliding window
class Solution2 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        // Determine which one is needle
        // if (haystack.length() < needle.length()) return strStr(needle, haystack);
        
        long hash = 0;
        long need = 0;
        for (int i = 0; i < needle.length(); i++) {
            hash += (long)((haystack.charAt(i)-96) * Math.pow(26, needle.length()-1-i));
            need += (long)((needle.charAt(i)-96) * Math.pow(26, needle.length()-1-i));
        }
        if (hash == need) return 0;
        
        for (int i = 1; i <= haystack.length() - needle.length(); i++) {
            hash = (hash - (long)((haystack.charAt(i-1)-96) * Math.pow(26, needle.length()-1))) * 26 + (long)(haystack.charAt(i+needle.length()-1)-96);
            if (hash == need) return i;
        }
        return -1;
    }
}

// time: O(n+m)