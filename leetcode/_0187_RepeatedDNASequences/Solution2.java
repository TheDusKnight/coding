package leetcode._0187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hashset + bit
class Solution2 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        // cc
        
        Map<Integer, Boolean> map = new HashMap<>();
        int n = s.length(), key = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            key = (key << 2 & 0xFFFFF) | convert(c); // 0xFFFFF：一个F等于四个1（F 16进制等于15），五个F等于二十个1；
            if (i < 9) continue;
            Boolean val = map.get(key);
            if (val == null) map.put(key, false);
            else if (!val) {
                res.add(s.substring(i-9, i+1));
                map.put(key, true);
            }
        }
        
        return res;
    }
    
    private int convert(char c) {
        switch(c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }
}

// time: O(N); space: O(1). constant factor比不使用bit小;
