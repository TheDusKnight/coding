package leetcode._0003_LongestSubstringWithoutRepeatingCharacters;

// sliding window hashmap O(N)
class Solution2ß {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Integer[] ascii = new Integer[256]; // 使用map记录char出现的位置
        int len = s.length(), longest = 0, l = 0;
        for (int r = 0; r < len; r++) {
            char c = s.charAt(r);
            if (ascii[c] != null) l = Math.max(l, ascii[c] + 1);
            
            ascii[c] = r;
            longest = Math.max(longest, r - l + 1);
        }
        
        return longest;
    }
}

// time: O(N); space: O(1);
