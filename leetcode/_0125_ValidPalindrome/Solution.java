package leetcode._0125_ValidPalindrome;

// 双指针站肩
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        
        int l = 0, r = s.length()-1;
        while (l < r) { // 左右越过，左右相邻也可
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);
            if (Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) return false;
            l++;
            r--;
        }
        
        return true;
    }
}

// time: O(N); space: O(1)

 