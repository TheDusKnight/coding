package leetcode._0680_ValidPalindromeII;

// 先找到invalid的位置，再比较去除invalid之后的substring是否valid
class Solution {
    private boolean isPalindromeRange(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        // for (int i = 0; i < s.length() / 2; i++) {
        //     if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        //         int j = s.length() - 1 - i;
        //         // 两种情况：包含i但不包含j，不包含i但包含j，只要有一种valid即可
        //         return (isPalindromeRange(s, i, j-1) || isPalindromeRange(s, i+1, j));
        //     }
        // }
        // return true;
        
        int l = 0, r = s.length()-1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return (isPalindromeRange(s, l, r-1) || isPalindromeRange(s, l+1, r));
            }
            l++;
            r--;
        }
        return true;
    }
}

// time: O(N); space: O(1);
