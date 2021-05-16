package leetcode._0219_ContainsDuplicateII;
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) throw new IllegalArgumentException();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) return true;
            map.put(nums[i], i);
        }
        return false;
    }
}