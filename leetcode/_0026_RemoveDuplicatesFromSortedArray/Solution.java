package leetcode._0026_RemoveDuplicatesFromSortedArray;

// 去重留一个
// 快慢针
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int slow = 1, n = nums.length, fast;
        
        for (fast = 1; fast < n; fast++) {
            if (nums[fast] != nums[slow-1]) {
                nums[slow++] = nums[fast];
            }
        }
        
        return slow;
    }
}

// time: O(N); space: O(1);
