package leetcode._0282_ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // dfs for loop
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        dfs(res, num, target, new StringBuilder(), 0, 0, 0);
        return res;
    }
    
    private void dfs(List<String> res, String num, int target, StringBuilder path, int idx, long lastVal, long sum) {
        int pLen = path.length();
        int sLen = num.length();
        if (idx == sLen) {
            // 可以使用basic cal的加减乘来eval最终结果是否valid
            if (sum == target)
                res.add(path.toString());
            return;
        }
        
        long val = 0;
        for (int i = idx; i < sLen; i++) {
            // 当前层的真实
            val = val * 10 + (num.charAt(i) - '0');
            // special check,第一位只能是数字
            if (pLen == 0) {
                path.append(val);
                // 注意是i+1而不是idx+1
                dfs(res, num, target, path, i+1, val, val);
                path.setLength(pLen);
                if (val == 0)
                    break;
                continue;
            }
            path.append("+" + val);
            dfs(res, num, target, path, i+1, val, sum+val);
            path.setLength(pLen);
            path.append("-" + val);
            dfs(res, num, target, path, i+1, -val, sum-val);
            path.setLength(pLen);
            path.append("*" + val);
            dfs(res, num, target, path, i+1, lastVal*val, sum-lastVal+lastVal*val);
            path.setLength(pLen);
            // 每段数字不容许以0开
            if (val == 0)
                break;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addOperators("123", 6));
    }
}

// time: O(4^n), n是input的长度; space: O(2*n)
