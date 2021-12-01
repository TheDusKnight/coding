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
                res = root; // 记录路径上比p大的值，每次更新得越来越小
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
// time: O(log(n)) if balanced, O(N) worst case

/**
 *          2
 *      /       \
 *     1         3
 */
