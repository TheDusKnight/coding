package leetcode._1446_ConsecutiveCharacters;

// array
class Solution {
    public int maxPower(String s) {
        if (s == null || s.length() == 0) throw new IllegalArgumentException();
        
        int count = 1, len = s.length(), power = 1; // 初始化错误
        for (int i = 1; i < len; i++) {
            if (s.charAt(i-1) == s.charAt(i)) count++;
            else {
                power = Math.max(power, count);
                count = 1;
            }
        }
        
        return Math.max(power, count); // 没有postprocessing，"cc"过不去
    }
}
