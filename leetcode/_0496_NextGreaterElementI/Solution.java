package leetcode._0496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;

// 自写 brute force, 使用map记录nums2的val和idx，loop nums1找到val对应nums2的位置，继续找next greater element
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            int idx2 = map.get(cur);
            boolean flag = false;
            while (idx2 < nums2.length) {
                if (nums2[idx2] > cur) {
                    res[i] = nums2[idx2];
                    flag = true;
                    break;
                }
                idx2++;
            }
            if (!flag) res[i] = -1;
        }
        
        return res;
    }
}

// time: O(n * m); space: O(m);