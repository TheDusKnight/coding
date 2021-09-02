package leetcode._0224_BasicCalculator;

import java.util.Stack;

// 后序表达式，逆波兰表达式？
// syntax tree or binary expression tree很重要！：怎么build？怎么算?

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        s = '(' + s + ')'; // 确保括号开头负数check
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        stack.push(0); // 防止出现只有一个数字的情况
        signStack.push(1);
        
        for (int i = 0; i <= len; i++) {
            char c = i < len ? s.charAt(i) : '+'; // 最后加一个add把剩下的两个数加起来
            
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i)))
                    num = num * 10 + (s.charAt(i++) - '0');
                i--;
                
                stack.push(num);
            } else if (c == '(') {
                stack.push(0);
                signStack.push(1);
                // check括号开头是负数
                int tmp = i;
                tmp++;
                while (tmp < len) {
                    if (s.charAt(tmp) == ' ') tmp++;
                    else if (s.charAt(tmp) == '-') {
                        stack.push(0);
                        break;
                    }
                    else break;
                }
            } else if (c == '+' || c == '-' || c == ')') {
                int top = stack.pop();
                int sign = signStack.pop();
                stack.push(stack.pop() + top * sign);
                
                if (c == '+') signStack.push(1);
                if (c == '-') signStack.push(-1);
            } else { // empty space: do nothing
                
            }
        }
        return stack.pop();
    }
}

// time: O(N); space: O(N);
