package leetcode._0020_ValidParentheses;
import java.util.Stack;

// 这道题只能用stack，不能用dfs，因为dfs无法保存不同种类括号的相对位置
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() <= 1) return false;
        
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if ((c == ')' && pop != '(') || (c == ']' && pop != '[') || (c == '}' && pop != '{')) return false;
            }
        }
        // 不要忘了postprocessing check empty
        return stack.isEmpty() == true ? true : false;
    }
}
// time: O(n) for loop 一遍string长度
// space: O(n) stack压入整个string