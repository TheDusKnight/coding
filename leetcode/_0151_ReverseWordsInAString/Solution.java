package leetcode._0151_ReverseWordsInAString;

// 全局reverse后局部reverse
class Solution {
    public String reverseWords(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() <= 1) return s;
        
        char[] ss = s.toCharArray();
        int len = ss.length;
        swap(ss, 0, len-1);
        
        int i = 0;
        for (int j = 0; j < len; j++) {
            if (j+1 < len && ss[j+1] == ' ') {
                swap(ss, i, j);
                i = j+2;
            }
        }
        // 如果最后一位不是空格需要手动触发swap
        if (i < len) swap(ss, i, len-1);
        
        return trimSpace(ss);
    }
    
    private String trimSpace(char[] ss) {
        int slow = 0, fast = 0, len = ss.length;
        while (fast < len) {
            while (fast < len && ss[fast] == ' ') fast++;
            while (fast < len && ss[fast] != ' ') ss[slow++] = ss[fast++];
            while (fast < len && ss[fast] == ' ') fast++;
            if (fast < len) ss[slow++] = ' ';
        }
        
        return new String(ss).substring(0, slow);
    }
    
    private void swap(char[] ss, int l, int r) {
        while (l < r) {
            char tmp = ss[l];
            ss[l] = ss[r];
            ss[r] = tmp;
            l++; r--;
        }
    }
}

// time: O(N); space: O(N)
