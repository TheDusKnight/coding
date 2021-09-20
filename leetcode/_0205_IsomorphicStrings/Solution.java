package leetcode._0205_IsomorphicStrings;
import java.util.HashMap;
import java.util.Map;

// 同型异构词，用两个hashMap分别存对应char
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        if (s.length() == 0 && t.length() == 0) return true;
        
        int n = s.length();
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap.containsKey(sChar)) {
                if (sMap.get(sChar) != tChar) return false;
            } else {
                sMap.put(sChar, tChar);
            }
            if (tMap.containsKey(tChar)) {
                if (tMap.get(tChar) != sChar) return false;
            } else {
                tMap.put(tChar, sChar);
            }
        }
        
        return true;
    }
}

// time: O(N); space: O(n+m);