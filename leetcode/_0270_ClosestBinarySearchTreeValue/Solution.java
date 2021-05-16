package leetcode._0270_ClosestBinarySearchTreeValue;
import leetcode.TreeNode;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) throw new RuntimeException("msg");

        TreeNode cur = root;
        int res = root.val;

        while (cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(res - target)) {
                res = cur.val;
            }
            
            if (cur.val < target) {
                cur = cur.right;
            }
            else if (cur.val > target) {
                cur = cur.left;
            } else {
                return cur.val;
            }
        }
        return res;
    }
}
