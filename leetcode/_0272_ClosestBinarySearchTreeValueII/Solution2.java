package leetcode._0272_ClosestBinarySearchTreeValueII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.TreeNode;

// bst + stack
class Solution2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        // 每次left stack和right stack的值都会越来越接近，最终stack顶层是最接近target的两个数，两个stack分成大小两个区间
        while (root != null) {
            if (root.val < target) {
                left.push(root);
                root = root.right;
            } else {
                right.push(root);
                root = root.left;
            }
        }
        
        while(k-- > 0) {
            if (!left.isEmpty() && !right.isEmpty()) {
                if (Math.abs(left.peek().val - target) < Math.abs(right.peek().val - target)) {
                    res.add(findNextLeft(left));
                } else {
                    res.add(findNextRight(right));
                }
            } else if (!left.isEmpty()) {
                res.add(findNextLeft(left));
            } else {
                res.add(findNextRight(right));
            }
        }
        
        return res;
    }
    // amortized时间复杂度O(1)，每个点最多只call了两次
    // 找到比当前节点小的最大值
    private int findNextLeft(Stack<TreeNode> left) {
        TreeNode cur = left.pop();
        int res = cur.val;
        cur = cur.left;
        while (cur != null) {
            left.push(cur);
            cur = cur.right;
        }
        return res;
    }
    // 找到比当前节点大的最小
    private int findNextRight(Stack<TreeNode> right) {
        TreeNode cur = right.pop();
        int res = cur.val;
        cur = cur.right;
        while (cur != null) {
            right.push(cur);
            cur = cur.left;
        }
        return res;
    }
}
// time: O(h + k); space: O(h)
