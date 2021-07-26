package leetcode._0340_LongestSubstringWithAtMostKDistinctCharacters;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k < 1) return 0;

        int max = 0, left = 0, numDisCh = 0;
        int[] count = new int[256];

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (count[c]++ == 0) numDisCh++;

            while (numDisCh > k) {
                count[s.charAt(left)]--;
                if (count[s.charAt(left)] == 0) numDisCh--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

// time: O(nk); space O(k)
