package leetcode._0238_ProductOfArrayExceptSelf;

// prefix sum (product)
// array记录每个num的prefix product，之后找每个num的suffix product同时相乘，最后返回
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // cc
        if (nums.length == 1) return new int[] {1};
        
        int n = nums.length;
        int[] res = new int[n];
        
        int product = nums[0];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = product;
            product *= nums[i];
        }
        
        product = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            res[i] *= product;
            product *= nums[i];
        }
        
        return res;
    }
}

// time: O(n); space: O(1);
