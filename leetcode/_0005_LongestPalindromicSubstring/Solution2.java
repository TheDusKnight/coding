package leetcode._0005_LongestPalindromicSubstring;

// 双指针两边往中间走
class Solution2 {
    public String longestPalindrome(String s) {
        // cc
        
        int n = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int oddLen = expandCenter(s, i, i); // 中心为odd
            int evenLen = expandCenter(s, i, i+1); // 中心为even
            int maxLen = Math.max(oddLen, evenLen);
            
            if (maxLen > (end - start +1)) {
                start = i - (maxLen - 1) / 2; // even i在靠左的位置
                end = i + maxLen / 2;
            }
        }
        
        return s.substring(start, end+1);
    }
    
    private int expandCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++; 
        }
        
        // r,l都出界，减完再减一才是len
        return r-l-1;
    }
}

// time: O(N^2); space: O(1);