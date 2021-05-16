package leetcode._0220_ContainsDuplicateIII;
import java.util.*;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(Long.valueOf(nums[i - k - 1]));
            Long upper = (long) nums[i] + t;
            Long lower = (long) nums[i] - t;

            Long tmp = set.lower(upper + 1);

            if (tmp != null && tmp >= lower) {
                return true;
            }

            set.add(Long.valueOf(nums[i]));
        }
        return false;
    }
}
