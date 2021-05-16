package leetcode._0268_MissingNumber;
import java.util.*;

// Sort -> binary search, check index and value;
public class Solution3 {
    public int missingNumber(int[] nums) {
        // cc
        
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] != 0) return 0;
        else if (nums[len-1] != len) return len;
        
        int left = 0, right = len-1, mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] == left ? right : left;
    }
}
