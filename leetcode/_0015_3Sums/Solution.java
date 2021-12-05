package leetcode._0015_3Sums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// array sort + n * twoSumII(one pass solution)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2)
            return res;

        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 如果i值重复，那么跳过
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            twoSumII(nums, res, i);
        }
        return res;
    }

    private void twoSumII(int[] nums, List<List<Integer>> res, int i) {
        int l = i + 1, r = nums.length - 1;
        while (l < r) { // 左右相等，用左右相邻不好做
            int curSum = nums[i] + nums[l] + nums[r];
            if (curSum == 0) {
                // 可以同时l++,r--的原因是三个元素，两个元素确定，只有第三个元素也是确定加和才不变
                // 当l++或r--，变的元素只能和上次一样才能加和不变，而题目不需要duplicate triplets所以直接l++,r--
                res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                // 即使l++,r--还是有可能出现两个元素完全和上次一样的情况
                while (l < r && nums[l] == nums[l - 1]) // 留一个即可
                    l++;
                while (l < r && nums[r] == nums[r + 1]) // 留一个即可
                    r--;
            } else if (curSum > 0) {
                r--;
            } else {
                l++;
            }
        }
    }
}

// time: O(n^2)
