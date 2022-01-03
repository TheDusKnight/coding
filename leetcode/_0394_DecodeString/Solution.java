package leetcode._0394_DecodeString;

import java.util.Stack;

// Stack 对称结构
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException();
        
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> it = new Stack<>();
        int val = 0, len = s.length();
        st.push(new StringBuilder()); // 加StringBuilder防止call穿栈
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                val = val * 10 + (c - '0');
            } else if (c >= 'a' && c <= 'z') {
                st.peek().append(c);
            } else if (c == '[') {
                it.push(val);
                val = 0;
                st.push(new StringBuilder()); // 加StringBuilder将上一层值隔开
            } else if (c == ']') {
                StringBuilder sb = st.pop();
                int time = it.pop();
                while (time-- > 0) st.peek().append(sb);
            }
        }
        
        return st.pop().toString();
    }
}

// time: O(2^N) 因为连续嵌套会呈指数级增长,2可以是任意数; space: O(2^N);