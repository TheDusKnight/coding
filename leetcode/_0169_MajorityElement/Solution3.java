package leetcode._0169_MajorityElement;

// bits
class Solution3 {
    public int majorityElement(int[] nums) {
        // cc
        
        int[] bits = new int[32];
        for (int n: nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += n & 1;
                n = n >> 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > nums.length / 2) {
                res += 1 << i;
            }
        }
        
        return res;
    }
}

// time: O(N); space: O(1);
