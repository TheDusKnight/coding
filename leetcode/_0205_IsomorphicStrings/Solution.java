package leetcode._0205_IsomorphicStrings;
import java.util.*;

// prefer two hashmap -> key value pair, index as value, check if char1 and char2 has same index before (不好写)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map_s = new HashMap<>();
        Map<Character, Character> map_t = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sCurr = s.charAt(i);
            char tCurr = t.charAt(i);
            char s2t;
            
            if (!map_s.containsKey(sCurr)) {
                map_s.put(sCurr, tCurr);
                s2t = tCurr;
            } else {
                s2t = map_s.get(sCurr);
            }
            
            char t2s;
            if (!map_t.containsKey(tCurr)) {
                map_t.put(tCurr, sCurr);
                t2s = sCurr;
            } else {
                t2s = map_t.get(tCurr);
            }
            
            
            if (sCurr != t2s || tCurr != s2t) return false;
        }
        return true;
    }
}
