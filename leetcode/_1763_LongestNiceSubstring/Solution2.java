package leetcode._1763_LongestNiceSubstring;

import java.util.HashSet;
import java.util.Set;

// divide and conquer
class Solution2 {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        
        for (char c: arr)
            set.add(c);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            // while (i < arr.length && !set.contains(Character.toUpperCase(c)) && !set.contains(Character.toLowerCase(c)))
            //     i++;
            String sub2 = longestNiceSubstring(s.substring(i+1));
            // 必须是>=s
            // if there are multiple, return the substring of the earliest occurrence
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        
        return s; // 如果一路continue，说明s是nice substring
    }
}
