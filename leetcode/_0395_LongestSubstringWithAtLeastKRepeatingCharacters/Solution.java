package leetcode._0395_LongestSubstringWithAtLeastKRepeatingCharacters;

import java.util.Arrays;

// brute force two loop
class Solution {
    public int longestSubstring(String s, int k) {
        // cc
        
        int[] countMap = new int[26];
        int n = s.length();
        int maxLen = 0;
        for (int start = 0; start < n; start++) {
            Arrays.fill(countMap, 0); // reset the count map
            for (int end = start; end < n; end++) {
                countMap[s.charAt(end) - 'a']++;
                if (isValid(s, start, end, k, countMap)) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        return maxLen;
    }
    
    private boolean isValid(String s, int start, int end, int k, int[] countMap) {
        int countLetters = 0, countAtLeastK = 0;
        for (int freq : countMap) { // check所有记录的letter是否大于k
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }
}

// time: O(n^2); space: O(1);
