package jianzhioffer.bit._15;

public class Solution2 {
    // mask左移
    public int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask << i) != 0) count++;
        }
        return count;
    }
}

// time: O(1); space: O(1)