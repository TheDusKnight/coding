package leetcode._0136_SingleNumber;
import java.util.*;

// hashset
public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            // if (!set.contains(num)) {
            //     set.add(num);
            // } else {
            //     set.remove(num);
            // }
            if (!set.remove(num)) set.add(num);
        }

        return set.iterator().next();
    }
}
