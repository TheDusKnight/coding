package leetcode._1763_LongestNiceSubstring;

import java.util.HashSet;

// brute force two for loop
class Solution {
    public String longestNiceSubstring(String s) {
        if (s == null) return null;
        if (s.length() == 1) return "";
        
        int len = s.length();
        int longest = 0;
        String res = "";
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                String sub = s.substring(i, j+1);
                if (nice(sub) && sub.length() > longest) {
                    res = sub;
                    longest = sub.length();
                }
            }
        }
        return res;
    }
    
    private boolean nice(String sub) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            set.add(c);
        }
        
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c)))
                return false;
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c)))
                return false;
        }
        return true;
    }
}

// time: O(n^2);
