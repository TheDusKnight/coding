package leetcode._0344_ReverseString;

// dfs
public class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;

        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int left, int right) {
        if (left >= right) return;
        
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        helper(s, left+1, right-1);
    }
}
