package leetcode._0215_KthLargestElementInAnArray;
import java.util.*;

// Sort and return kth element, Time O(n*log(n)) O(1) → count/bucket sort
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len-k];
    }
}