package leetcode._0272_ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

public class Solution {
    // bst + stack
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> l = new Stack<>();
        Stack<TreeNode> r = new Stack<>();

        TreeNode cur = root;
        // 每次left stack和right stack的值都会越来越接近，最终stack顶层是最接近target的两个数，两个stack分成大小两个区间
        while (cur != null) { // O(h) ~ O(log(n))
            if (cur.val < target) {
                l.push(cur);
                cur = cur.right;
            } else {
                r.push(cur);
                cur = cur.left;
            }
        }
        while (k-- > 0) { // O(k)
            if (!l.isEmpty() && !r.isEmpty()) {
                if (Math.abs((double) l.peek().val - target) < Math.abs((double) r.peek().val - target)) {
                    res.add(getNextLeft(l));
                } else {
                    res.add(getNextRight(r));
                }
            } else if (!l.isEmpty()) {
                res.add(getNextLeft(l));
            } else {
                res.add(getNextRight(r));
            }
        }
        return res;
    }
    // amortized时间复杂度O(1)
    private int getNextLeft(Stack<TreeNode> left) {
        TreeNode top = left.pop();
        int res = top.val;
        TreeNode cur = top.left;
        while (cur != null) {
            left.push(cur);
            cur = cur.right;
        }
        return res;
    }

    private int getNextRight(Stack<TreeNode> right) {
        TreeNode top = right.pop();
        int res = top.val;
        TreeNode cur = top.right;
        while (cur != null) {
            right.push(cur);
            cur = cur.left;
        }
        return res;
    }
}
// time: O(h + k); space: O(h)
