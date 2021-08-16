package leetcode._0124_BinaryTreeMaximumPathSum;
import leetcode.TreeNode;

// 面经题
// recursion, any node to any node
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max; // 注意return的不是maxSum return的值
    }
    
    private int maxSum(TreeNode node) { // return 含义：从叶子结点到当前node的max path max
        if (node == null) return 0;
        int left = maxSum(node.left);
        int right = maxSum(node.right);
        // any to curNode一条路径
        int curMax = Math.max(Math.max(left, right), 0) + node.val;
        // update global max if needed
        // left and right to curNode公共祖先路径
        max = Math.max(max, Math.max(left + right + node.val, curMax));
        return curMax;
        // return any to curNode max path sum 不return公共祖先路径
    }
}

// time: O(N). N is number of nodes, since we visit each node not more than 2 times;
// space: O(log(N) ~ N);