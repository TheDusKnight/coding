package leetcode._0224_BasicCalculator;

import java.util.Stack;

// 自写 post processing写法
class Solution2 {
    public int calculate(String s) {
        // cc
        
        s = '(' + s + ')'; // 确保括号开头负数check
        int len = s.length();
        Stack<Integer> signSt = new Stack<>();
        Stack<Integer> numSt = new Stack<>();
        signSt.push(1); numSt.push(0); // 防止出现只有一个数字的情况
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while(i < len && Character.isDigit(s.charAt(i)))
                    num = num*10 + (s.charAt(i++) - '0');
                i--;
                numSt.push(num);
            } else if (c == '(') {
                signSt.push(1);
                numSt.push(0);
                for (int idx = i+1; idx < len; idx++) {
                    if (s.charAt(idx) != ' ') {
                        if (s.charAt(idx) == '-') numSt.push(0);
                        break;
                    }
                }
            } else if (c == ')' || c == '+' || c == '-') {
                int top = numSt.pop();
                int sign = signSt.pop();
                int cal = numSt.pop() + top*sign;
                numSt.push(cal);
                if (c == '+') signSt.push(1);
                if (c == '-') signSt.push(-1);
            }
        }
        
        int top = numSt.pop(); // post processing, stack里有两个元素
        return numSt.pop() + top*signSt.pop();
    }
}

// time: O(N); space: O(N);
