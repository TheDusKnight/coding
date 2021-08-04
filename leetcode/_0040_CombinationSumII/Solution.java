package leetcode._0040_CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums); // sort之后才能跳过相同值的元素
        dfs(nums, res, path, target, 0, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int target, int sum, int idx) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (sum > target || idx >= nums.length) // idx check不加也行
            return;

        for (int i = idx; i < nums.length; i++) {
            // 从dfs过来的因为是叠加所以可以重复，而for loop过来的因为上一次相同元素被删了所以相当于全套大保健又来一遍
            if (i > idx && nums[i] == nums[i-1])
                continue;
            path.add(nums[i]);
            dfs(nums, res, path, target, sum + nums[i], i+1); // 不添加同一个点多次
            // 要么成功返回，要么失败返回，set back去下一个idx
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }
}

// time: O(2^n); space: O(n);
