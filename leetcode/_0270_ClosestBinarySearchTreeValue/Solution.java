package leetcode._0270_ClosestBinarySearchTreeValue;
import leetcode.TreeNode;

public class Solution {
    // bst. best solution 因为没有压栈并且利用了bst特性
    public int closestValue(TreeNode root, double target) {
        // cc
        TreeNode cur = root;
        int res = root.val;
        while (cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(res - target)) {
                res = cur.val;
            }
            if (cur.val > target) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return res;
    }
}

// time: O(log(n));
