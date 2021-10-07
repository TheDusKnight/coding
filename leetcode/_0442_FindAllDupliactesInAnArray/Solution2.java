package leetcode._0442_FindAllDupliactesInAnArray;

import java.util.ArrayList;
import java.util.List;

// array mark negative
class Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
        // cc
        
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int markIdx = Math.abs(nums[i]) - 1;
            int mark = nums[markIdx];
            if (mark < 0) res.add(Math.abs(nums[i]));
            nums[markIdx] = -mark;
        }
        
        return res;
    }
}

// time: O(N); space: O(1);
