package leetcode._0792_NumberOfMatchingSubsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Array。使用bucket保存每个word和当前需要match的letter
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // cc
        
        int res = 0;
        List<StringBuilder>[] list = new List[26];
        Arrays.setAll(list, ele -> new ArrayList<>());
        for (String word: words)
            list[word.charAt(word.length()-1) - 'a'].add(new StringBuilder(word));
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            List<StringBuilder> match = list[c - 'a'];
            list[c - 'a'] = new ArrayList<>();
            
            for (StringBuilder sb: match) {
                sb.deleteCharAt(sb.length()-1);
                if (sb.length() != 0) {
                    list[sb.charAt(sb.length()-1) - 'a'].add(sb);
                } else res++;
            }
        }
        
        return res;
    }
}

// time: O(sLen); space: O(wordsLen * word average length);
