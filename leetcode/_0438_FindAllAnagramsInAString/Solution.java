package leetcode._0438_FindAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Brute Force每个idx check是否是valid Anagrams
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // cc
        
        List<Integer> res = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        
        for (int i = 0; i < sLen; i++) {
            if (i + pLen - 1 < sLen) {
                String sub = s.substring(i, i+pLen);
                char[] sArr = sub.toCharArray();
                Arrays.sort(sArr);
                int j = 0;
                for (j = 0; j < pLen; j++) {
                    if (pArr[j] != sArr[j]) break;
                }
                if (j == pLen) res.add(i);
            }
        }
        
        return res;
    }
}
