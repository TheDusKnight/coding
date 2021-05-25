package leetcode._0022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    // dfs + stack验证，时间复杂度高
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), n);
        return res;
    }

    private void dfs(List<String> res, StringBuilder path, int n) {
        if (path.length() == 2 * n) {
            if (isValid(path.toString())) {
                res.add(path.toString());
            }
            return;
        }

        int len = path.length(); // 非必要
        path.append('(');
        dfs(res, path, n);
        path.setLength(len);
        // path.setLength(path.length()-1);

        path.append(')');
        dfs(res, path, n);
        path.setLength(len);
        // path.setLength(path.length()-1);
    }

    private boolean isValid(String path) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            char curChar = path.charAt(i);
            if (curChar == '(') {
                stack.push('(');
            } else {
                if (stack.empty())
                    return false;
                stack.pop();
            }
        }
        if (!stack.empty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.generateParenthesis(3));
    }
}

// time: O(2^n+)
