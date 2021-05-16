package leetcode._0268_MissingNumber;
import java.util.*;

// HashSet || HashMap（没必要）
class Solution4 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        int len = nums.length;
        for (int i = 0; i <= len; i++) {
            if (!set.contains(i)) return i;
        }
        return -1;
    }
}
