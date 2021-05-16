package leetcode._0268_MissingNumber;
import java.util.*;

// one pass check cur and past element difference
class Solution {
    public int missingNumber(int[] nums) {
        // cc
        if (nums == null || nums.length == 0) throw new RuntimeException("msg");
        // when length is 1
        int len = nums.length;
        
        Arrays.sort(nums);
        // 检查首位是否正常
        if (nums[0] != 0) return 0;
        else if (nums[len-1] != len) return len;
        // 检查中间是否正常
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i-1] == 2) {
                return i;
            }
        }
        // either last or first element is wrong
        return nums[len-1] == len ? 0 : len;
    }
}
