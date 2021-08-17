package leetcode._0235_LowestCommonAncestorOfABinaarySearchTree;
import leetcode.TreeNode;

// All Node.val are unique.
// 这题可以直接用recursion自下而上返回公共祖先做，但时间复杂度高
// dfs 类似for loop
// 公共祖先node一定不会碰到null，因为在此之前一定会被找到
// 利用bst性质和公共祖先性质，反证法证明第一次出现比p，q值之间的node为公共祖先
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        
        int parentVal = root.val;
        int pVal = p.val;
        int qVal = q.val;
        if (parentVal > pVal && parentVal > qVal) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (parentVal < pVal && parentVal < qVal) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

// time: O(N)