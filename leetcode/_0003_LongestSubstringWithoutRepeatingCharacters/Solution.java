package leetcode._0003_LongestSubstringWithoutRepeatingCharacters;

// sliding window hashset O(2N) amortized, 每个位置最多add和remove一次
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        boolean[] ascii = new boolean[256];
        int l = 0, longest = 0;
        for (int r = 0; r < s.length(); r++) {
            while (ascii[s.charAt(r)]) {
                ascii[s.charAt(l)] = false;
                l++;
            }
            longest = Math.max(longest, r-l+1);
            ascii[s.charAt(r)] = true;
        }
        
        return longest;
    }
}

// time: O(2N); space: O(1);
