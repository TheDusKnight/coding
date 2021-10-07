package leetcode._0442_FindAllDupliactesInAnArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// You must write an algorithm that runs in O(n) time and uses only constant extra space.
// Brute force使用 hash set
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // cc
        
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) {
                res.add(num);
            }
        }
        
        return res;
    }
}

// time: O(N); space: O(N);
