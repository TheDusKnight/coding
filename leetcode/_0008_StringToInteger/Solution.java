package leetcode._0008_StringToInteger;

// if else逻辑
class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        s = s.trim();
        int begin = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char curVal = s.charAt(i);
            if (curVal != ' ') {
                if (curVal == '-' || curVal == '+') {
                    if (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                        begin = i+1;
                        if (curVal == '-') sign = -1;
                        else sign = 1;
                    } else return 0;
                } else if (Character.isDigit(s.charAt(i))) {
                    begin = i;
                } else {
                    return 0;
                }
                break;
            }
        }
        
        if (s.length() == 0) return 0;
        int res = Character.getNumericValue(s.charAt(begin));
        for (int i = begin+1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return res * sign;
            }
            // 判断乘10后是否会出界
            if (res + Character.getNumericValue(s.charAt(i)) > Integer.MAX_VALUE / 10 + 7) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + Character.getNumericValue(s.charAt(i));
        }
        return res * sign;
    }
}
