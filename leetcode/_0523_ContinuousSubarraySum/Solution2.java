package leetcode._0523_ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

// Math
// say the the difference is d between a and b, such as d = b - a(b is on the right of a). you want d is multiple of k, so you just need d % k = 0. Because d = b - a, so d % k = 0 = (b - a) %k. so (b-a)%k=0 equal b%k - a%k = 0, then b%k = a%k. Comparing other hashtable based problem, you need check b-k whether in the hashtable. In this problem , you always check b%k, and always pust a%k into hashtable. when k = 0, you need do it as other similar problem.
class Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) return false;
        
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (i >= 1 && curSum % k == 0) return true; // 检查[0,i] subarray sum是否满足条件
            if (map.containsKey(curSum % k)) { // 检查b % k == a % k并且index距离大于等于2,注意b-a index不包含a本身
                if (i - map.get(curSum % k) >= 2) return true;
            }
            else
                map.put(curSum % k, i);
        }
        
        return false;
    }
}

// time: O(N); space: O(K);
