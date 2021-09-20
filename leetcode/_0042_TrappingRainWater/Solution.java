package leetcode._0042_TrappingRainWater;

// brute force，对于每个点，找到能储存的水量
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        
        int n = height.length;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            int leftMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = 0;
            for (int j = n-1; j > i; j--) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int water = Math.min(leftMax, rightMax) - height[i];
            if (water < 0) water = 0; // 防止当前water为负数
            res += water;
        }
        
        return res;
    }
}

// time: O(N^2); space: O(1)

