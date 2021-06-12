package leetcode._0095_UniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class Solution {
    // bst + dfs warm up question
    public List<TreeNode> generateTrees(int n) {
        if (n < 0)
            return null;
        return dfs(1, n);
    }
    
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) { // 不能左右相等因为闭闭区间有一个值相当于叶子节点，左右越过相当于null
            res.add(null); // leave node 挂着个null
            return res;
        }
        
        for (int r = start; r <= end; r++) {
            List<TreeNode> lefts = dfs(start, r-1);
            List<TreeNode> rights = dfs(r+1, end);
            for (TreeNode left: lefts) {
                for (TreeNode right: rights) {
                    // 每次new一个新的root否则res里存的都是同一个root
                    TreeNode root = new TreeNode(r);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

// time: O(n^n)
// 每个node左右节点各n/2种可能性，每层一共n种可能性，一共n层所以O(n^n)