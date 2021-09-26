package leetcode._0496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 使用stack记录元素大小，当有更大的元素时并pop出stack元素
class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // cc
        
        int n1 = nums1.length, n2 = nums2.length;
        int[] res = new int[n1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) map.put(nums1[i], i); // nums1 val, nums1 idx;
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n2; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int idx = map.get(stack.pop());
                res[idx] = nums2[i];
            }
            
            if (map.containsKey(nums2[i])) stack.push(nums2[i]);
        }
        
        // post-processing
        while (!stack.isEmpty()) {
            int idx = map.get(stack.pop());
            res[idx] = -1;
        }
        
        return res;
    }
}

// n是较小的array
// time: O(n+m); space: O(n);
