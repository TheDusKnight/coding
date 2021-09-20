package leetcode._0042_TrappingRainWater;

// two pointer 双指针站肩, one pass
class Solution3 {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        
        int leftMax = 0, rightMax = 0, res = 0, n = height.length;
        int left = 0, right = n-1;
        while (left < right) { // 一定左右相等跳出
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        
        return res;
    }
}
