package leetcode._0136_SingleNumber;
import java.util.*;

// pointer
class Solution2 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        
        Arrays.sort(nums);
        int cur = 1;
        while (cur < nums.length-1) {
            if (nums[cur-1] != nums[cur]) return nums[cur-1];
            cur += 2;
        }
        return nums[nums.length-1];
    }
}

// time: n*log(n)