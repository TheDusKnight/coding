package leetcode._0439_TernaryExpressionParser;

import java.util.Stack;

// stack 对称结构
class Solution {
    public String parseTernary(String expression) {
        // cc
        
        String s = expression;
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = len-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '?') {
                char exp1 = stack.pop(), exp2 = stack.pop();
                stack.push(s.charAt(--i) == 'T' ? exp1 : exp2);
            } else if (c != ':') {
                stack.push(c);
            }
        }
        
        return String.valueOf(stack.pop());
    }
}

// time: O(N); space: O(N);
