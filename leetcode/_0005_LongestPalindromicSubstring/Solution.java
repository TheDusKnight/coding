package leetcode._0005_LongestPalindromicSubstring;

// 两边往中间走：双指针确定位置 O(n^2), 两边往中间走check palindromic O(n)，一共O(n^3)
// 中间往两遍：从n个基数位加n-1个偶数位开花，往两边走O(n),一共O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLen = aroundCenter(s, i, i);
            int evenLen = aroundCenter(s, i, i+1);
            int maxLen = Math.max(oddLen, evenLen);
            
            if (maxLen > end - start) {
                // 当长度是偶数时i在中间偏左，所以左边界离i更近
                start = i - (maxLen-1) / 2;
                end = i + maxLen / 2;
            }
        }
        // substring [inclusive, exclusive)
        return s.substring(start, end+1);
    }
    
    private int aroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // 左开右开区间多加了一次
        return R-L-1;
    }
}
