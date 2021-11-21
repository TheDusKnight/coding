package leetcode._0137_SingleNumberII;

// bit count每位出现的次数
class Solution {
    public int singleNumber(int[] nums) {
        // cc
        
        int[] bits = new int[32];
        for (int num: nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += num & 1;
                num = num >> 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 == 1) {
                res += 1 << i;
            }
        }
        
        return res;
    }
}

// time: O(N); space: O(1);
