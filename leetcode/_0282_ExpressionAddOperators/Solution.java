package leetcode._0282_ExpressionAddOperators;

import java.util.*;

// dfs+stack进行加减乘运算
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null)
            return res;
        dfs(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void dfs(String num, int target, List<String> res, StringBuilder sb, int idx, long lastVal, long sum) {
        if (idx == num.length() && sum == target) {
            res.add(sb.toString());
            return;
        }
        if (idx == num.length()) {
            return;
        }

        long val = 0;
        int len = sb.length(); // ?
        for (int i = idx; i < num.length(); i++) {
            val = val * 10 + (num.charAt(i) - '0'); // 当前层的真实值

            // special check,第一位只能是数字
            if (sb.length() == 0) {
                sb.append(val);
                dfs(num, target, res, sb, i + 1, val, val);
                sb.setLength(len);
                // continue;
            } else {
                sb.append("+" + val);
                dfs(num, target, res, sb, i + 1, val, sum + val);
                sb.setLength(len);

                sb.append("-" + val);
                dfs(num, target, res, sb, i + 1, -val, sum - val);
                sb.setLength(len);

                sb.append("*" + val);
                dfs(num, target, res, sb, i + 1, lastVal * val, sum - lastVal + lastVal * val);
                sb.setLength(len);
            }

            if (val == 0) // 每段数字不容许以0开头
                break;
        }
    }
}
// time: O(4^n)