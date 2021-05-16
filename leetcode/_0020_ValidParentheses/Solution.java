package leetcode._0020_ValidParentheses;
import java.util.*;

// 这道题只能用stack，不能用dfs，因为dfs无法保存不同种类括号的相对位置
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else {
                if (stack.size() == 0) return false;
                
                char cur = stack.pop();
                if (cur == '(' && s.charAt(i) != ')' || cur == '{' && s.charAt(i) != '}' || cur == '[' && s.charAt(i) != ']') return false;
            }
        }
        
        if (stack.size() > 0) return false;
        return true;
    }
}
// time: O(n)
// space: O(n)