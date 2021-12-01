package leetcode._0653_TwoSumIVInputIsABST;

import java.util.Stack;

import leetcode.TreeNode;

// bst + stack
// Solution 2: 两个stack，左stack模拟array中的left++，右stack模拟right--
public class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> lStack = new Stack<>();
        Stack<TreeNode> rStack = new Stack<>();
        TreeNode cur = root;
        // init left stack
        initLeftStack(lStack, cur);
        initRightStack(rStack, cur);
        // 左右stack永远不会为空，因为如果没有return true最终左右node一定会相遇并返回false，此时左右stack还剩一个node
        while (!lStack.isEmpty() && !rStack.isEmpty()) {
            TreeNode left = lStack.peek(); // peek()错写成pop()
            TreeNode right = rStack.peek();
            // 相当于sort array中的左右相等,也可用来判断tree size是否为1
            if (left == right) {
                return false;
            }
            if (left.val + right.val == k) {
                return true;
            } else if (left.val + right.val < k) { // left++
                // 也可以left, right 初始化为stack.peek()，通过return top更新left和right，效果是一样的
                lStackGoRight(lStack);
            } else { // right--
                rStackGoLeft(rStack);
            }
        }
        return false; // 永远不会走到这一步
    }

    private void initLeftStack(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private void initRightStack(Stack<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
    }

    private void lStackGoRight(Stack<TreeNode> stack) {
        TreeNode top = stack.pop();
        TreeNode cur = top.right;
        // 展开右子树
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        // 最终stack顶部是root左区间的last（最右）node，也就是r--
    }

    private void rStackGoLeft(Stack<TreeNode> stack) {
        TreeNode top = stack.pop();
        TreeNode cur = top.left;
        // 展开左子树
        while (cur != null) {
            stack.push(cur);
            cur = cur.right;
        }
        // 最终stack顶部是root右区间的first（最左）node，也就是l++
    }
}

// time: O(N); space: O(log(N)) if balanced, O(N) if not
