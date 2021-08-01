package leetcode._0078_Subsets;
import java.util.ArrayList;
import java.util.List;

// 老刘 dfs1,无脑先加结果，答案在每个node
// binary reduction

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
        // 永远都是add在存东西，remove只是在下一次add之前删去元素，它自己无法存入sol
        for (int i = index; i < nums.length; i++) { // 如果index越界，进入不了for loop直接return
            sub.add(nums[i]); // 也可以每次创建新的object不需要回溯但不推荐
            dfs(nums, i+1, sub, sol);
            sub.remove(sub.size()-1); // 和solution2不一样在后面没有dfs直接把不加的结果存入sol,不重复
            // remove后的sub不能立即放入sol，例如_1不能变成__否则会有重复
        }
    }

    // 在for loop中加入结果的写法，跟上面逻辑一摸一样没有任何区别
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // cc
        
        res.add(new ArrayList<Integer>());
        dfs2(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

    private void dfs2(List<List<Integer>> res, int[] nums, List<Integer> path, int idx) {
        int sLen = nums.length;
        int pLen = path.size();
        if (idx == sLen) {
            return;
        }
        
        for (int i = idx; i < sLen; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<Integer>(path));
            dfs2(res, nums, path, i+1);
            path.remove(pLen);
        }
    }
}
