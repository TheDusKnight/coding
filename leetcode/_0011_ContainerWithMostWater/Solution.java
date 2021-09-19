package leetcode._0011_ContainerWithMostWater;

// 双指针站肩
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = Integer.MIN_VALUE;
        // 左右相邻
        while (l + 1 < r) {
            int len = r - l;
            max = Math.max(max, len * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        // 注意一定有post-processing
        return Math.max(max, (r-l) * Math.min(height[l], height[r]));
    }
}

// time: O(N); space: O(1)
