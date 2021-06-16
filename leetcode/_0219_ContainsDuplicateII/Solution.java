package leetcode._0219_ContainsDuplicateII;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // set + slicing window
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || k < 0)
            throw new IllegalArgumentException("Invalid input");
        if (nums.length == 0 || k == 0)
            return false;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]); // set remove的是值不是index
            }
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}

// time: O(n); space: O(n)