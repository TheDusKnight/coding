package leetcode._0078_Subsets;
import java.util.*;

// dfs1,无脑先加结果，答案在每个node
// binary reduction?
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return null; // 需要讨论
        
        List<Integer> sub = new ArrayList<>();
        List<List<Integer>> sol = new ArrayList<>();
        dfs(nums, 0, sub, sol);
        return sol;
    }
    
    private void dfs(int[] nums, int index, List<Integer> sub, List<List<Integer>> sol) {
        sol.add(new ArrayList<>(sub));
        
        for (int i = index; i < nums.length; i++) {
            sub.add(nums[i]); // 也可以每次创建新的object不需要回溯但不推荐
            dfs(nums, i+1, sub, sol);
            sub.remove(sub.size()-1);
        }
    }
}
