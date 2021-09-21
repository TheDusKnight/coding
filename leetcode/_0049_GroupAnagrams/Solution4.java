package leetcode._0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 根据一个string最多不超过100优化Solution3
class Solution4 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // cc
        if (strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        char[] count = new char[26];
        
        for (String s: strs) {
            Arrays.fill(count, 'a');
            for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
            
            
            String key = String.valueOf(count);
            
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

// time: O(KN); space: O(KN)
