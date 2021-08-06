package leetcode._0032_LongestValidParentheses;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int l = 0, r = 0, maxLen = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') l++;
            else r++;
            if (r > l) l = r = 0;
            if (l != 0 && r != 0 && l == r) maxLen = Math.max(maxLen, l * 2);
        }
        l = 0; r = 0;
        for (int i = len-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(') l++;
            else r++;
            if (l > r) l = r = 0;
            if (l != 0 && r != 0 && l == r) maxLen = Math.max(maxLen, l * 2);
        }
        
        return maxLen;
    }
}

// time: O(n); space: O(1)
