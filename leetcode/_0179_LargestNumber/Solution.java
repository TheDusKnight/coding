package leetcode._0179_LargestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// array sort
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, (o1, o2) -> {
            // the only two cases when concat two string
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            
            return s2.compareTo(s1); // 从大到小
        });
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if (ss[0].charAt(0) == '0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s: ss) sb.append(s);
        
        return sb.toString();
    }
}

// time: O(n*k*log(n)) k是compare string的长度; space: O(n);
