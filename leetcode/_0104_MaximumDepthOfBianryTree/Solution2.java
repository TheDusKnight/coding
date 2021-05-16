package leetcode._0104_MaximumDepthOfBianryTree;
import leetcode.TreeNode;

// 标准recursion
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// time: O(n) 每个node都遍历一遍 or 2^0 + 2^1 + 2^2 + ... + 2^(log(2, n)-1) = 2^0 + 2^1 + 2^2 + ... + n/2 = n
// space: stack O(log(n)) to O(n)