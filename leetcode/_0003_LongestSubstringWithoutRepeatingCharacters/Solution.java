package leetcode._0003_LongestSubstringWithoutRepeatingCharacters;
import java.util.*;

// sliding window hashset O(2n) amortized, 每个位置最多add和remove一次
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0, slow = 0, fast;
        for (fast = 0; fast < s.length(); fast++) {
            char curVal = s.charAt(fast);
            if (!set.contains(curVal)) {
                set.add(curVal);
                // 如果在这里算res相当于每遇到一个distinct number就要算一次时间复杂度不好
                // res = Math.max(res, fast - slow + 1);
            } else {
                res = Math.max(res, fast - slow);
                while (set.contains(curVal)) {
                    set.remove(s.charAt(slow++));
                }
                set.add(curVal);
            }
        }
        
        // post-processing, 如果没有进入else的情况
        return Math.max(res, fast - slow);
    }
}
