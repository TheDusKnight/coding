package leetcode._0090_SubsetsII;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {
    // 算法哥DFS
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // cc
        
        Arrays.sort(nums); // 聚合，跳过连续的数字
        res.add(new ArrayList<Integer>());
        dfs(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, int idx) {
        int sLen = nums.length;
        int pLen = path.size();
        if (idx == sLen)
            return;
        
        for (int i = idx; i < sLen; i++) {
            // 确保i-1是从当前层for loop过来的，而不是从上一层过来的i
            // 当遇到连续的数字时，确保不会skip prefix
            if (i != idx && nums[i] == nums[i-1])
                continue;
            
            path.add(nums[i]);
            res.add(new ArrayList<Integer>(path));
            dfs(res, nums, path, i+1);
            path.remove(pLen);
        }
    }
}
