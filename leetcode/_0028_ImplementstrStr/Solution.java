package leetcode._0028_ImplementstrStr;

// 定长sliding window
// 讨论当needle为空时返回什么，此处返回0
class Solution {
    public int strStr(String haystack, String needle) {
        // cc
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            // index of res;
            if (j == needle.length()) return i;
        }
        // 别忘了最后没找到return-1或者讨论
        return -1;
    }
}
// time: O(n*m)