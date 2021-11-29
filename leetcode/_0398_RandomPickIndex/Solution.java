package leetcode._0398_RandomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// naive hashmap
class Solution {
    Map<Integer, List> map;
    public Solution(int[] nums) {
        // cc
        
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        if (list == null) throw new RuntimeException();
        
        int idx = new Random().nextInt(list.size());
        return list.get(idx);
    }
}

// time: O(N) init + O(1) pick; space: O(N);

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
