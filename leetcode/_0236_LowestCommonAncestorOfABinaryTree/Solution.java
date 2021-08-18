package leetcode._0236_LowestCommonAncestorOfABinaryTree;
import leetcode.TreeNode;

// recursion 自下而上返回公共祖先
// 面经考到过
// 不保证一定有p, q如何处理? preprocess 找出p和q，p和q必须是TreeNode
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        // 如果p或q就是公共祖先而另一个在公共祖先的subtree会检测不出来
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        // 找到代表一路向上返回代表
        if (left != null) return left;
        if (right != null) return right;
        // 左右都没找到代表
        return null;
    }
}

// time: O(N); space: O(log(N) ~ N);
// followup: lc1664