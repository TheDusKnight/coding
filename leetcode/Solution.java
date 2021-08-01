package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // cc
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        dfs(nums, res, new ArrayList<Integer>(), idx);
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int idx) {
        res.add(new ArrayList<Integer>(path));
        
        path.add(nums[idx]);
        dfs(nums, res, path, idx+1);
        path.remove(nums[idx]);
        dfs(nums, res, path, idx+1);
    }
}

// time: O(n*m); space: O(n*m);
