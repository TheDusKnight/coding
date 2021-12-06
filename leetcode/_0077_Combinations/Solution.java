package leetcode._0077_Combinations;
import java.util.*;

// dfs第二类搜索树
class Solution {
    List<List<Integer>> res;
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0) return res;
        
        this.n = n; this.k = k;
        List<Integer> list = new ArrayList<>();
        dfs(1, list);
        
        return res;
    }
    // 一共k层，分n个叉
    private void dfs(int num, List<Integer> list) {
        if (list.size() == k) { // 终止多加了一个variable check但没必要
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = num; i <= n; i++) {
            list.add(i);
            dfs(i+1, list);
            list.remove(list.size()-1);
        }
    }
}

// time: O(n^k); space: O(k);