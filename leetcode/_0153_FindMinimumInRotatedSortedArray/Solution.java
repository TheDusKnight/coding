package leetcode._0153_FindMinimumInRotatedSortedArray;

// Brute force for loop check min;
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) return nums[i];
        }
        return nums[0];
    }
}

// time: O(n), space: O(1);
