package leetcode._0340_LongestSubstringWithAtMostKDistinctCharacters;

// by 算法哥
// hashmap -> 256 ASCII + sliding window
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) return 0;

        // num = number of distinct
        int len = s.length(), num = 0, slow = 0, res = 0;
        int count[] = new int[256];

        for (int fast = 0; fast < len; fast++) {
            char c = s.charAt(fast);
            // char转换成数字, 计算目前distinct数量
            if (count[c]++ == 0) {
                // leetcode过不去?
                // count[c]++;
                // System.out.println(count[c]);
                num++;
            }
            // 如果distinct num超过k，开始从slow减
            while (num > k) {
                if (--count[s.charAt(slow++)] == 0) {
                    num--;
                }
            }
            // 每次更新res, 左闭右闭区间
            res = Math.max(res, fast - slow + 1);
        }
        return res;
    }
}