package leetcode._0169_MajorityElement;

// 摩尔投票两两抵消
class Solution2 {
    public int majorityElement(int[] nums) {
        // cc
        
        int candidate = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) candidate = nums[i];
            if (nums[i] == candidate) count++;
            else count--;
        }
        
        return candidate;
    }

    // public int majorityElement(int[] nums) {
    //     // cc
        
    //     Integer candidate = null;
    //     int count = 0;
    //     for (int num: nums) {
    //         if (count == 0) {
    //             candidate = num;
    //         }
            
    //         count += num == candidate ? 1 : -1;
    //     }
        
    //     return candidate;
    // }
}

// time: O(n); space: O(1);
