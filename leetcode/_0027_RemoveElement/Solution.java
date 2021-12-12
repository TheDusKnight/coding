package leetcode._0027_RemoveElement;

// in-place deduplicate similar to LC26
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) throw new IllegalArgumentException();
        
        int slow = 0, len = nums.length;
        for (int fast = 0; fast < len; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        
        return slow;
    }
}

// time: O(N); space: O(1);
