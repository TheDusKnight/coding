package leetcode._0049_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// hashMap sort string as key
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // cc
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String key = String.valueOf(tmp);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}

// time: O(N*K*log(K)), K is the longest string length; space: O(N*K);
