package leetcode._0136_SingleNumber;

// bit
class Solution3 {
    public int singleNumber(int[] nums) {
        // cc
        
        int a = 0;
        for (int n: nums) {
            a = a^n;
        }
        
        return a;
    }
}

// time: O(N); space: O(1);