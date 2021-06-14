package leetcode._0250_CountUnivalueSubtrees;

import leetcode.TreeNode;

public class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        // target value可以是任意值，因为不会check第一次dfs。
        dfs(root, 0);
        return count;
    }
    
    private boolean dfs(TreeNode root, int last) {
        if (root == null)
            return true;
        // 左右都要check之后再返回，否则右边有可能无法更新
        boolean rL = dfs(root.left, root.val);
        boolean rR = dfs(root.right, root.val);
        if (!rL || !rR) // 只要有一个是false该层dfs就不会valid
            return false;
        count++; // 只要左右都返回true，count++
        return root.val == last; // 如果左右都是true，check本身值和上一层值是否相同
    }
}

// time: O(n)