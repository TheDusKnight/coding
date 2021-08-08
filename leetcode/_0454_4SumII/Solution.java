package leetcode._0454_4SumII;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // array + HashMap。使用HashMap貌似无法做closest match
    // 不用考虑结果重复，因为结果一样4个index的不一样表示不同结果。需要跟面试官沟通
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // cc
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a: nums1)
            for (int b: nums2)
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
        for (int c: nums3)
            for (int d: nums4)
                count += map.getOrDefault(-(c+d), 0);
        return count;
    }
}

// time: O(n^2); space: O(n^2). Three could be up to n^2 distinct a+b keys;