package leetcode._0285_InorderSuccessorInBST;

import leetcode.TreeNode;

public class Solution {
    // bst特性, result一定出现在bst路径上，所以只要找到路径上的比p大的最小值即可
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // cc
        TreeNode res = null;
        while (root != null) {
            // 往小（左）区间找
            if (root.val > p.val) {
                res = root; // mark一下当前node为可能为结果因为只有值更大的node才有可能是结果，可能p在左下还没走过，也可能在左上走过头了
                root = root.left;
            } else {
                // 往大（右）的区间找
                root = root.right;
            }
        }
        // 如果不存在in-order successor说明没有比p.val大的值，res没有赋值，return null
        return res;
    }
}
// time: O(log(n))

/**
 *          2
 *      /       \
 *     1         3
 */
