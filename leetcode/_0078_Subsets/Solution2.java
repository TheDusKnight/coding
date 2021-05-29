package leetcode._0078_Subsets;
import java.util.ArrayList;
import java.util.List;

// dfs2, 答案在leaf node
// linear reduction?
class Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // cc
        
        dfs(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> path, int idx) {
        int sLen = nums.length;
        int pLen = path.size();
        if (idx == sLen) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        path.add(nums[idx]);
        dfs(res, nums, path, idx+1);
        path.remove(pLen);
        dfs(res, nums, path, idx+1);

        // 这种拼单词的逻辑不行，有些时候前面不加的元素，后面也不能加，这个word break不一样
        // for (int i = idx; i < sLen; i++) {
        //     path.add(nums[i]);
        //     dfs(res, nums, path, i+1);
        //     path.remove(path.size()-1);
        // }
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[] input = new int[]{1,2,3};
        System.out.println(sol.subsets(input));
    }
}