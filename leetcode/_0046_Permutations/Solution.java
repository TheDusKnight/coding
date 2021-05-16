package leetcode._0046_Permutations;
import java.util.*;

// dfs第二类搜索树
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // cc?
        
        List<Integer> nums_l = new ArrayList<>();
        for (int n : nums) {
            nums_l.add(n);
        }
        dfs(nums_l, 0, res);
        return res;
    }
    
    private void dfs(List<Integer> nums_l, int index, List<List<Integer>> res) {
        // 答案出在leaf node
        if (index == nums_l.size()-1) {
            res.add(new ArrayList<>(nums_l));
            return;
        }
        
        // 只能和后面的元素swap，不能回头swap因为会有重复
        for (int i = index; i < nums_l.size(); i++) {
            Collections.swap(nums_l, index, i);
            dfs(nums_l, index+1, res); //一共nums_l.size()-1层
            Collections.swap(nums_l, index, i);
        }
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        Solution sol = new Solution();
        System.out.println(sol.permute(input));
    }
}

//                            1,2,3
//                1,2,3       2,1,3       3,2,1
//        1,2,3   1,3,4   2,1,3   2,3,1   3,2,1   3,1,2