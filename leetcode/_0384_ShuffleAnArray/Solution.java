package leetcode._0384_ShuffleAnArray;

import java.util.Arrays;
import java.util.Random;

// Fisher-Yates Algorithm, 就是design扑克牌的shuffle方法

class Solution {
    int[] resetArray;
    int[] nums;
    Random rand;
    int n;

    public Solution(int[] nums) {
        // cc
        
        n = nums.length;
        resetArray = Arrays.copyOf(nums, n);
        this.nums = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        // 注意不能直接让nums等于resetArray否则shuffle会出错
        // nums = resetArray.clone();
        nums = Arrays.copyOf(resetArray, n);
        return resetArray;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < n; i++) {
            swap(i, i + rand.nextInt(n - i));
        }
        
        return nums;
    }
    
    private void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

// time: O(n); space: O(n);

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
