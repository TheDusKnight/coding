package leetcode._0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// convert character freq to string as key in hashMap
class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // cc
        if (strs.length == 0) return new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        
        for (String s: strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                // sb.append("#" + count[i]); // 时间复杂度高
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

// time: O(KN); space: O(KN)
