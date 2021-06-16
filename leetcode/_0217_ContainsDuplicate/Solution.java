package leetcode._0217_ContainsDuplicate;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // HashSet
    // 不能用count sort因为val是离散的
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) // 如果不能add说明之前add过一次了
                return true;
        }
        return false;
    }
}

// time: O(n); space: O(n)
