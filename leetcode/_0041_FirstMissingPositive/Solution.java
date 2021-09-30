package leetcode._0041_FirstMissingPositive;

import java.util.HashSet;
import java.util.Set;

// brute force使用hashset

class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int n: nums) {
            if (n > 0) set.add(n);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        
        return nums.length + 1;
    }
}

// time: O(n); space: O(n);
