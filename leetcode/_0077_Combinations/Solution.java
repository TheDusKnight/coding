package leetcode._0077_Combinations;
import java.util.*;

// dfs第二类搜索树
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // cc?
        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    // 一共k层，分n个叉
    // index指当前到1...n的哪个数了
    private void dfs(int n, int k, int index, List<Integer> sub, List<List<Integer>> res) {
        if (sub.size() == k) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = index; i <= n; i++) {
            sub.add(i);
            dfs(n, k ,i+1, sub, res);
            sub.remove(sub.size()-1);
        }
    }
}