package leetcode._0227_BasicCalculatorII;

// one pass with lastVal without stack
class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int len = s.length();
        int curVal = 0, lastVal = 0, res = 0;
        char oprt = '+'; // ?
        for (int i = 0; i < len; i++) {
            char curChar = s.charAt(i);
            if (Character.isDigit(curChar)) { // 合并数字
                curVal = (curVal * 10) + (curChar - '0');
            }
            if (!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == len - 1) {
                if (oprt == '+' || oprt == '-') {
                    res += lastVal;
                    lastVal = (oprt == '+') ? curVal : -curVal;
                } else if (oprt == '*') {
                    lastVal = lastVal * curVal;
                } else if (oprt == '/') {
                    lastVal = lastVal / curVal;
                }
                oprt = curChar;
                curVal = 0;
            }
        }
        // post processing
        res += lastVal;
        return res;
    }
}

// time: O(N); space: O(1)
