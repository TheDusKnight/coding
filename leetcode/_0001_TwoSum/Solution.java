package leetcode._0001_TwoSum;

// Brute force
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // cc

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}

// time: O(n^2); space: O(1);
