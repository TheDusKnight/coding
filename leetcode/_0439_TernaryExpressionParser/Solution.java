package leetcode._0439_TernaryExpressionParser;

import java.util.Stack;

// stack 对称结构
class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return expression;
        
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int i = expression.length() - 1;
        
        while (i >= 0) {
            char c = expression.charAt(i);
            if (c == ' ') {
                i--;
            } else if (c == ':') {
                i--;
            }else if (c == '?') {
                char express = expression.charAt(--i);
                Character tChar = stack.pop();
                Character fChar = stack.pop();
                if (express == 'T') stack.push(tChar);
                if (express == 'F') stack.push(fChar);
                i--;
            } else {
                stack.push(c);
                i--;
            }
        }
        
        res.append(stack.pop());
        return res.toString();
    }
}

// time: O(N); space: O(N);
