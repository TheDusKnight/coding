package leetcode._1822_SignOftheProductOfAnArray;

// Microsoft高频
// array
class Solution {
    public int arraySign(int[] nums) {
        // cc
        
        int sign = 1;
        for (int num: nums) {
            if (num == 0) return 0;
            if (num < 0) sign *= -1;
        }
        
        return sign;
    }
}
