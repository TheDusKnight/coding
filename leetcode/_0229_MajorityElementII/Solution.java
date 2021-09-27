package leetcode._0229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

// 摩尔投票，all elements that appear more than ⌊ n/3 ⌋ times最多2个
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // cc
        
        int count1 = 0, count2 = 0;
        Integer can1 = null, can2 = null;
        for (int n: nums) {
            if (can1 != null && can1 == n) {
                count1++;
            } else if (can2 != null && can2 == n) {
                count2++;
            } else if (count1 == 0) {
                can1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                can2 = n;
                count2 = 1;
            } else { // 说明当前元素既不是can1也不是can2
                count1--;
                count2--;
            }
        }
        
        // 题目要求post check结果是否确实是众数
        List<Integer> res = new ArrayList<>();
        int iter1 = 0, iter2 = 0;
        for (int n: nums) {
            if (can1 != null && can1 == n) iter1++;
            else if (can2 != null && can2 == n) iter2++;
        }
        
        int n = nums.length;
        if (iter1 > (n/3)) res.add(can1);
        if (iter2 > (n/3)) res.add(can2);
        
        return res;
    }
}

// time: O(n); space: O(1);
