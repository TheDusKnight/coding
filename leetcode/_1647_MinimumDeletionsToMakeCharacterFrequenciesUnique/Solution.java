package leetcode._1647_MinimumDeletionsToMakeCharacterFrequenciesUnique;

import java.util.HashSet;
import java.util.Set;

// count sort + hash set
class Solution {
    int count;
    public int minDeletions(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() <= 1) return 0;
        
        count = 0;
        int len = s.length();
        int[] letterCounts = new int[26];
        Set<Integer> usedCounts = new HashSet<>();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            letterCounts[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            while (usedCounts.contains(letterCounts[i]) && letterCounts[i] > 0) {
                count++;
                letterCounts[i]--;
            }
            usedCounts.add(letterCounts[i]);
        }
        
        return count;
    }
}

// time: O(N); space: O(1)
