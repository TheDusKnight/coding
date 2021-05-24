package leetcode._0104_MaximumDepthOfBianryTree;
import leetcode.TreeNode;

public class Solution {
    // recursion剪枝但其实没有必要，因为如果left or right是null，return为0，那么在另一边不为0的情况max下一定不会选null的一边
    public int maxDepth(TreeNode root) {
        // cc + base case;
        if (root == null) return 0;

        if (root.left != null && root.right != null) return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        else if (root.left != null) return maxDepth(root.left)+1;
        else return maxDepth(root.right)+1;
    }
    // 标准recursion
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    // dfs
    int maxDepth = Integer.MIN_VALUE;
    public int maxDepth3(TreeNode root) {
        getMaxDepth(root, 0);
        return maxDepth;
    }
    
    private void getMaxDepth(TreeNode root, int curDepth) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, curDepth);
            return;
        }
        
        getMaxDepth(root.left, curDepth+1);
        getMaxDepth(root.right, curDepth+1);
    }
}
// time: O(n) 每个node都遍历一遍 or 2^0 + 2^1 + 2^2 + ... + 2^(log(2, n)-1) = 2^0 + 2^1 + 2^2 + ... + n/2 = n
// space: stack O(log(n)) to O(n)