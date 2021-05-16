package leetcode._0028_ImplementstrStr;

// two pointers
class Solution {
    public int strStr(String haystack, String needle) {
        // cc
        if (haystack == null || needle == null) return -1;
        // if (haystack.length() == 0 && needle.length() == 0) return 0;
        // if (needle.length() == 0) return 0;
        
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