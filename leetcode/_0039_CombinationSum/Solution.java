package leetcode._0039_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        List<Integer> path = new ArrayList<>();
        dfs(nums, res, path, target, 0, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int target, int sum, int idx) {
        if (sum > target || idx >= nums.length)
            return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, res, path, target, sum + nums[i], i); // 和subset，permutation不同在不断添加同一个idx
            // 要么成功返回，要么失败返回，set back去下一个idx
            path.remove(path.size() - 1);
        }
    }
}
