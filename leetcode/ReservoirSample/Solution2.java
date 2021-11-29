package leetcode.ReservoirSample;

import java.util.Random;

// size为1的水库采样without extra space
class Solution2 {
    int[] nums;
    public Solution2(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count = 0, sample = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                int rand = new Random().nextInt(++count);
                if (rand == 0) sample = i;
            }
        }
        
        return sample;
    }
}

// time: O(1) init + O(N); space: O(1);

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
