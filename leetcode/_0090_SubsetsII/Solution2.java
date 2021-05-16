package leetcode._0090_SubsetsII;
import java.util.*;

// 算法哥DFS
// 再看看为什么去重是保留前缀？
public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        helper(res, new ArrayList<Integer>(), nums, 0);
        
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        int len = nums.length;
        if (index == len) return;

        for (int i = index; i < len; i++) {
            // 保证只能在开头(i == index)时，选择连续重复的数字，保留前缀
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }

            path.add(nums[i]);
            List<Integer> copy = new ArrayList<Integer>(path);
            res.add(copy);
            helper(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
