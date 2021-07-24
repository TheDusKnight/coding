package leetcode._0159_LongestSubstringwithAtMostTwoDistinctCharacters;

// two pointer
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        char c1 = '\0', c2 = '\0';
        int idx1 = -1, idx2 = -1, start = 0, max = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == c1) { // 更新最近c1的位置
                idx1 = i;
            } else if (c == c2) { // 更新最近c2的位置
                idx2 = i;
            } else {
                if (idx1 < idx2) {
                    start = idx1+1; // start往右缩到排除idx1
                    c1 = c;
                    idx1 = i;
                } else {
                    start = idx2+1; // start往右缩到排除idx2
                    c2 = c;
                    idx2 = i;
                }
            }
            max = Math.max(i - start + 1, max); // [i, start]区间长度加一
        }
        return max;
    }
}

// time: O(n); space: O(1);