package leetcode._0046_Permutations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// dfs第二类搜索树答案出在leaf node
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
    
    // nums_l已经存了所有需要存的元素，不需要nums了
    private void dfs(List<Integer> nums_l, int index, List<List<Integer>> res) {
        // 答案出在leaf node
        if (index == nums_l.size()-1) { // 或者nums_l.size()也可以，最后一层自己和自己换
            res.add(new ArrayList<>(nums_l));
            return;
        }
        
        for (int i = index; i < nums_l.size(); i++) { 
            Collections.swap(nums_l, index, i);
            dfs(nums_l, index+1, res); // 一共nums_l.size()-1层
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
//        1,2,3   1,3,2   2,1,3   2,3,1   3,2,1   3,1,2

// dfs第一层idx 0和0换，和1换，和2换
// 第二层idx 1和1换，和2换
// 第三层idx 2和2换。或者不需要换因为反正自己和自己换是一样的，直接返回没有第四层
// 第四层输出结果