package leetcode._0047_PermutationsII;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// dfs第二类搜索树答案出在leaf node
// 只能用set做并且set不能reuse, 不能用sort因为swap位置会发生变化,重复的位置可能变得不连续,sort也只能保持初始状态sort
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> nums_l = new ArrayList<>();
        for (int num: nums) {
            nums_l.add(num);
        }
        dfs(nums_l, 0, res);
        return res;
    }

    private void dfs(List<Integer> nums_l, int index, List<List<Integer>> res) {
        if (index == nums_l.size() - 1) {
            res.add(new ArrayList<>(nums_l));
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums_l.size(); i++) {
            if (set.add(nums_l.get(i))) {
                Collections.swap(nums_l, i, index);
                dfs(nums_l, i+1, res);
                Collections.swap(nums_l, i, index);
            }
        }
    }
}
