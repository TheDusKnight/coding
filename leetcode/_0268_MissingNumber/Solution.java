package leetcode._0268_MissingNumber;
import java.util.Arrays;

public class Solution {
    // sort
    public int missingNumber(int[] nums) {
        // cc
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[len-1] != len) return len;
        
        for (int i = 0; i < len; i++) {
            if (i != nums[i]) { return i; }
        }
        return -1;
        
        // binary search优化
        // int left = 0, right = nums.length-1, mid = 0;
        // while (left + 1 < right) {
        //     mid = left + (right - left) / 2;
        //     if (nums[mid] == mid) {
        //         left = mid;
        //     } else {
        //         right = mid;
        //     }
        // }
        // return nums[left] == left ? right : left;
    }
}

// time: O(n*log(n)); space: O(1)
