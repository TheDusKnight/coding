package leetcode._0042_TrappingRainWater;

// 计划存储，先从左到右和从右到左扫一遍，找到每个点的leftMax和rightMax并储存，然后再扫一遍算出每个点的water
class Solution2 {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) return 0;
        
        int n = height.length;
        int res = 0;
        
        int[] leftMaxs = new int[n];
        int leftMax = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxs[i] = leftMax;
        }
        int[] rightMaxs = new int[n];
        int rightMax = 0;
        for (int i = n-1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            rightMaxs[i] = rightMax;
        }
        
        for (int i = 0; i < n; i++) {
            int water = Math.min(rightMaxs[i], leftMaxs[i]) - height[i];
            if (water < 0) water = 0;
            res += water;
        }
        
        return res;
    }
}

// time: O(N); space: O(N);

