package leetcode._0104_MaximumDepthOfBianryTree;
import leetcode.TreeNode;

// recursion剪枝但其实没有必要，因为如果left or right是null，return为0，那么在另一边不为0的情况max下一定不会选null的一边
public class Solution {
    public int maxDepth(TreeNode root) {
        // cc + base case;
        if (root == null) return 0;

        if (root.left != null && root.right != null) return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        else if (root.left != null) return maxDepth(root.left)+1;
        else return maxDepth(root.right)+1;
    }
}