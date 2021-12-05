package leetcode._0014_LongestCommonPrefix;

// arr操作
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // cc
        
        int arrLen = strs.length, strLen = strs[0].length();
        int i = 0;
        for (i = 0; i < strLen; i++) {
            int j = 0;
            for (j = 1; j < arrLen; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) break;
            }
            if (j != arrLen) break;
        }
        return strs[0].substring(0, i);
    }
}

// time: O(N); space: O(1);
