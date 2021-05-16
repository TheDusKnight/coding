package leetcode._0268_MissingNumber;
import java.util.*;

// one pass check index == element
public class Solution2 {
    public int missingNumber(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) throw new RuntimeException();

        int len = nums.length;
        Arrays.sort(nums);
        if (nums[len-1] != len) return len;

        for (int i = 0; i < len; i++) {
            if (nums[i] != i) return i;
        }

        return -1;
    }
}
