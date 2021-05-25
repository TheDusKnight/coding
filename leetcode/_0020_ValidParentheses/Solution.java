package leetcode._0020_ValidParentheses;
import java.util.Stack;

// 这道题只能用stack，不能用dfs，因为dfs无法保存不同种类括号的相对位置
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == '(' || curChar == '[' || curChar == '{') {
                stack.push(curChar);
            } else {
                if (stack.empty()) // 避免pop不出来的情况
                    return false;
                char pop = stack.pop();
                if ((curChar == ')' && pop != '(') || (curChar == ']' && pop != '[') || (curChar == '}' && pop != '{')) {
                    return false;
                }
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }
}
// time: O(n) for loop 一遍string长度
// space: O(n) stack压入整个string