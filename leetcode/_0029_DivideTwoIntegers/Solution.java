package leetcode._0029_DivideTwoIntegers;

// bit operation
public class Solution {
   public int divide(int dividend, int divisor) {
       if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

       long p = Math.abs((long) dividend);
       long q = Math.abs((long) divisor);

       int res = 0;
       while (p >= q) {
           int shift = 0;
           // 每次shift最大的一位 
           while (p >= (q << shift)) {
               shift++;
           }
           res += 1 << (shift - 1);
           p -= q << (shift - 1);
       }
       if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) return -res;
       return res;
   }
}