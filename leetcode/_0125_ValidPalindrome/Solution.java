package leetcode._0125_ValidPalindrome;

class Solution {
    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            // 最好check一下是否越界
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
}
