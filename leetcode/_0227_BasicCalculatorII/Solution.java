package leetcode._0227_BasicCalculatorII;

// one pass with lastVal without stack
class Solution {
    public int calculate(String s) {
        // cc
        
        int lastVal = 0, curVal = 0, res = 0;
        char lastOprt = '+';
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                while (i < len && Character.isDigit(s.charAt(i))) // 合并数字
                    curVal = curVal * 10 + (s.charAt(i++) - '0');
                i--;
                
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == len - 1) {
                if (lastOprt == '+' || lastOprt == '-') {
                    res += lastVal;
                    lastVal = lastOprt == '+' ? curVal : -curVal;
                } else if (lastOprt == '*') {
                    lastVal = lastVal * curVal;
                } else if (lastOprt == '/') {
                    lastVal = lastVal / curVal;
                }
                lastOprt = c;
                curVal = 0;
            }
        }
        // post processing
        res += lastVal;
        return res;
    }
}

// time: O(N); space: O(1)
