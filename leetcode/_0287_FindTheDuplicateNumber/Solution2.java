package leetcode._0287_FindTheDuplicateNumber;

// 龟兔赛跑找slow fast相同时的index
class Solution2 {
    public int findDuplicate(int[] nums) {
        // cc
        
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    }
}

// time: O(n); space: O(1);
