package leetcode._0438_FindAllAnagramsInAString;
import java.util.*;

// count sort + sliding windows
// 类似LC242 ValidAnagram
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int ns = s.length(), np = p.length();
        if (s == null || s.length() == 0 || ns < np) return res;
        
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        
        // add p count sort
        for (int i = 0; i < np; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        // add s count sort
        for (int i = 0; i < ns; ++i) {
            sCount[s.charAt(i) - 'a']++;
            // 加一个减一个模拟滑动窗口
            if (i >= np) {
                sCount[s.charAt(i - np) - 'a']--;
            }
            
            if (Arrays.equals(pCount, sCount)) {
                // Add start index to result
                res.add(i - np + 1);
            }
        }
        return res;
    }
}
