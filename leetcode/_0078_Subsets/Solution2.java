package leetcode._0078_Subsets;
import java.util.*;

// dfs2, 答案在leaf node
// linear reduction?
class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        helper(nums, 0, sub, sol);
        return sol;
    }
    
    private void helper(int[] nums, int level, List<Integer> sub, List<List<Integer>> sol) {
        if (level >= nums.length) {
            sol.add(new ArrayList<>(sub));
            return;
        }
        // 加
        sub.add(nums[level]);
        helper(nums, level+1, sub, sol);
        // 回溯
        sub.remove(sub.size()-1);
        // 不加
        helper(nums, level+1, sub, sol);
    }
}