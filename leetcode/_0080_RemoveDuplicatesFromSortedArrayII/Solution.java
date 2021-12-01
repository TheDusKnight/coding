package leetcode._0080_RemoveDuplicatesFromSortedArrayII;

// 去重留两个，留k个
// 快慢针
class Solution {
    // public int removeDuplicates(int[] nums) {
    //     if (nums.length <= 2) return nums.length;
        
    //     int slow = 2, fast, n = nums.length;
        
    //     for (fast = 2; fast < n; fast++) {
    //         int cur = nums[fast];
    //         int count = 0;
    //         for (int i = slow-2; i <= slow-1; i++) {
    //             if (nums[i] == cur) count++;
    //         }
    //         // 不需要count，只需要check slow后第k位是否duplicate即可
    //         if (count < 2) nums[slow++] = nums[fast];
    //     }
        
    //     return slow;
    // }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow-2]) nums[slow++] = nums[fast];
        }
        
        return slow;
    }
}

// time: O(N); space: O(1);
