package leetcode._0224_BasicCalculator;

import java.util.Stack;

// 自写 post processing写法
class Solution2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException();
        
        s = '(' + s + ')'; // 确保括号开头负数check
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        stack.push(0); // 防止出现只有一个数字的情况
        signStack.push(1);
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                stack.push(num);
            } else if (c == '(') {
                stack.push(0);
                signStack.push(1);
                
                int tmp = i+1;
                while (tmp < len) {
                    if (s.charAt(tmp) == ' ') {
                        tmp++;
                    } else if (s.charAt(tmp) == '-') {
                        stack.push(0);
                        break;
                    } else {
                        break;
                    }
                }
            } else if (c == ')' || c == '+' || c == '-') {
                int top = stack.pop();
                int sign = signStack.pop();
                
                int cal = stack.pop() + sign*top;
                stack.push(cal);
                
                if (c == '+') signStack.push(1);
                if (c == '-') signStack.push(-1);
            }
        }
        // post processing, stack里有两个元素
        int top = stack.pop();
        return stack.pop() + signStack.pop()*top;
    }
}

// time: O(N); space: O(N);
