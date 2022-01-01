package leetcode._0016_3SumClosest;

import java.util.Arrays;

// array
class Solution {
    int[] nums;
    int len;
    int target;
    int closet;
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) throw new IllegalArgumentException();
        
        Arrays.sort(nums);
        this.nums = nums;
        len = nums.length;
        this.target = target;
        closet = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            twoSumII(i);
            // check res是否已经最接近target，如果是后面不用找了, 运行速度快
            if (closet == target) return closet; 
        }
        
        return closet;
    }
    
    private void twoSumII(int idx) {
        int left = idx+1, right = len-1;
        
        while (left < right) {
            int cur = nums[idx] + nums[left] + nums[right];
            if (cur == target) {
                closet = cur;
                break;
            }
            if (Math.abs(cur - target) < Math.abs(closet - target)) {
                closet = cur;
            }
            if (cur - target > 0) {
                right--;
                while (left < right && nums[right] == nums[right+1]) right--;
            }
            else {
                left++;
                while (left < right && nums[left] == nums[left-1]) left++;
            }
        }
    }
}

// time: O(n^2); space: O(1);
