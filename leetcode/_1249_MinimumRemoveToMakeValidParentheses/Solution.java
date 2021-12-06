package leetcode._1249_MinimumRemoveToMakeValidParentheses;

// two pass偷鸡，和lc32类似
class Solution {
    public String minRemoveToMakeValid(String s) {
        // cc
        
        int delta = 0;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        // pass 1: remove all invalid ')'
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') delta++;
            else if (c == ')') {
                if (delta == 0) continue;
                delta--;
            }
            sb.append(c);
        }
        
        delta = 0; len = sb.length();
        StringBuilder res = new StringBuilder();
        // pass 2: remove all invalid '('
        for (int i = len-1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == ')') delta++;
            else if (c == '(') {
                if (delta == 0) continue;
                delta--;
            }
            res.append(c);
        }
        
        return res.reverse().toString();
    }
}

// time: O(N); space: O(N);
