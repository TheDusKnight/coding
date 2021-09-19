package leetcode._0008_StringToInteger;

// 高频
// 不使用trim，先找begin digit index再转换数
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        // s = s.trim();
        int beginIdx = 0, sign = 1, n = s.length();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            char charVal = s.charAt(i);
            if (charVal != ' ') {
                if (charVal == '-' || charVal == '+') {
                    if (i+1 < n && Character.isDigit(s.charAt(i+1))) {
                        beginIdx = i+1;
                        if (charVal == '-') sign = -1;
                        else sign = 1;
                    } else 
                        return 0;
                } else if (Character.isDigit(s.charAt(i))) {
                    beginIdx = i;
                } else {
                    return 0;
                }
                flag = true;
                break;
            }
        }
        
        if (!flag) return 0; // 不使用trim
        
        int res = 0;
        for (int i = beginIdx; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) return res * sign;
            
            int curVal = s.charAt(i) - '0';
            // 判断乘10后是否会出界
            if (res + curVal > Integer.MAX_VALUE/10 + 7) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res = res * 10 + curVal;
        }
        
        return res * sign;
    }
}

// time: O(N); space: O(1)