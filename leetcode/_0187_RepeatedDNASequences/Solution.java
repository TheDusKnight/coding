package leetcode._0187_RepeatedDNASequences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// HashMap + substring sliding window查看String出现次数
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) return res;
        
        Map<String, Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i));
            if (sb.length() == 10) {
                String cur = sb.toString();
                int freq = map.getOrDefault(cur, 0) + 1;
                map.put(cur, freq);
                if (freq == 2) res.add(cur);
                
                sb.deleteCharAt(0);
            }
        }
        
        return res;
    }
}

// time: O(N*L), L is is 10 in this problem; space: O(1). 4^10种可能性;
