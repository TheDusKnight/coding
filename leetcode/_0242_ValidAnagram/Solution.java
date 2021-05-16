package leetcode._0242_ValidAnagram;
import java.util.*;

// 和LC28 strStr比较hash
// two hashset -> one hashset -> sort -> countSort() -> character frequency hash
// 加一个减一个
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i))) {
                int count = map.get(t.charAt(i)) - 1;
                if (count < 0) return false;
                map.put(t.charAt(i), count);
            } else {
                return false;
            }
        }
        return true;
    }
}

// time: On)
// space: O(k) 根据题意，k不超过26个字母