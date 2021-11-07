package leetcode._0125_ValidPalindrome;

// 双指针站肩
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        
        s = s.toLowerCase().trim();
        int n = s.length(), l = 0, r = n-1;
        
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}

// time: O(N); space: O(1)

 