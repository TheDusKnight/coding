package leetcode._0042_TrappingRainWater;

// two pointer 双指针站肩, one pass
// 每次算一个格子的值
class Solution3 {
    public int trap(int[] height) {
        // cc
        
        int len = height.length, leftMax = 0, rightMax = 0, left = 0, right = len-1, count = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) leftMax = height[left];
                else count += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) rightMax = height[right];
                else count += rightMax - height[right];
                right--;
            }
        }
        
        return count;
    }
}
