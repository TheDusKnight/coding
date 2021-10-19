package leetcode._0080_RemoveDuplicatesFromSortedArrayII;

// 去重留两个，留k个
// 快慢针
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int slow = 2, fast, n = nums.length;
        
        for (fast = 2; fast < n; fast++) {
            int cur = nums[fast];
            int count = 0;
            for (int i = slow-2; i <= slow-1; i++) {
                if (nums[i] == cur) count++;
            }
            if (count < 2) nums[slow++] = nums[fast];
        }
        
        return slow;
    }
}

// time: O(N); space: O(1);
