package leetcode._0215_KthLargestElementInAnArray;
import java.util.Arrays;

public class Solution {
    // sort, return kth element
    public int findKthLargest(int[] nums, int k) {
        // cc
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-k];
    }
}

// time: O(n*log(n))