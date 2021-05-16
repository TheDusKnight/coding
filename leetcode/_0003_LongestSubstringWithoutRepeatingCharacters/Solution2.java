package leetcode._0003_LongestSubstringWithoutRepeatingCharacters;
import java.util.*;

// hashmap
class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return 1;
        
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int fast = 0, slow = 0; fast < len; fast++) {
            char curVal = s.charAt(fast);
            if (map.containsKey(curVal)) {
                // update slow [a,b,b,a]
                slow = Math.max(map.get(s.charAt(fast)), slow);
            }
            // 左闭右闭区间长度 fast - slow + 1。 fast++后左闭右开区间 fast - slow
            res = Math.max(res, fast - slow + 1);
            map.put(s.charAt(fast), fast + 1);
        }
        return res;
    }
}

// time: O(n)
