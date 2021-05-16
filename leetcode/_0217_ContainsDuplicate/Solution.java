package leetcode._0217_ContainsDuplicate;
import java.util.*;

// hash-set
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) throw new IllegalArgumentException();
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
