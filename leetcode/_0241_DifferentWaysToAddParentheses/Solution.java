package leetcode._0241_DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // dfs recursion + syntax tree
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0)
            return null;
        return dfs(expression, 0, expression.length()-1);
    }

    private List<Integer> dfs(String expression, int start, int end) {
        List<Integer> res = new ArrayList<>();
        // 可以在for loop之后check res是否为empty，如果是说明当前substring都是数字
        // if (isNumber(expression, start, end)) {
        //     res.add(Integer.valueOf(expression.substring(start, end+1)));
        //     return res;
        // }

        for (int i = start; i <= end; i++) {
            char cur = expression.charAt(i);
            if (cur == '+' || cur == '-' || cur == '*') {
                List<Integer> lefts = dfs(expression, start, i-1);
                List<Integer> rights = dfs(expression, i+1, end);
                for (Integer left: lefts) {
                    for (Integer right: rights) {
                        res.add(cal(cur, left, right));
                    }
                }
            }
        }
        
        if (res.isEmpty()) {
            res.add(Integer.valueOf(expression.substring(start, end+1)));
            return res;
        }
        
        return res;
    }

    // private boolean isNumber(String expression, int start, int end) {
    //     for (int i = start; i <= end; i++) {
    //         char c = expression.charAt(i);
    //         int res = Character.getNumericValue(c);
    //         if (res == -1 || res == -2) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    private int cal(char cur, Integer left, Integer right) {
        if (cur == '+') {
            return left + right;
        }
        if (cur == '-') {
            return left - right;
        }
        return left * right;
    }
}
