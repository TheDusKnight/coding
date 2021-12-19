package leetcode._0394_DecodeString;

import java.util.Stack;

// Stack 对称结构
class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        
        Stack<StringBuilder> st = new Stack<>();
        Stack<Integer> it = new Stack<>();
        st.push(new StringBuilder()); // 加StringBuilder防止call穿栈
        int val = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                val = val*10 + (c - '0');
            } else if (Character.isAlphabetic(c)) {
                st.peek().append(c);
            } else if (c == '[') {
                it.push(val);
                val = 0;
                // 加StringBuilder防止call穿栈
                st.push(new StringBuilder());
            } else if ( c == ']') {
                StringBuilder cur = st.pop();
                int count = it.pop();
                while (count-- > 0) {
                    st.peek().append(cur);
                }
            }
        }
        
        String res = st.peek().toString();
        return res;
    }
}

// time: O(2^N) 因为连续嵌套会呈指数级增长,2可以是任意数; space: O(2^N);