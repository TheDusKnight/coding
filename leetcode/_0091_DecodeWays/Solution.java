package leetcode._0091_DecodeWays;
import java.util.*;
// 有考过，最优解是DP
// recursive with memoization
class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    private int recursiveWithMemo(int index, String str) {
        // ec， 顺序很重要
        // Return 1 for success. Leave node挂着null
        if (index == str.length()) return 1;
        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') return 0;
        // 如果最后一位不是0那么ans+1，防止arrayIndexOutOfBoundException
        if (index == str.length()-1) return 1;
        
        // Memoization index as key, saving memory for same subproblem.
        // 记录当index为某个数时，有多少种可能性。
        if (memo.containsKey(index)) return memo.get(index);
        
        int ans = recursiveWithMemo(index+1, str);
        // 如果大于26说明绝不可能有两位数decode成一个字母的情况
        if (Integer.parseInt(str.substring(index, index+2)) <= 26)
            ans += recursiveWithMemo(index+2, str);
        
        // Save for memoization
        memo.put(index, ans);
        
        return ans;
    }
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        return recursiveWithMemo(0, s);        
    }
}

// N is length of the string
// time: O(N)
// space: O(N)
// N is length of the string
// time: O(N)
// space: O(N)
