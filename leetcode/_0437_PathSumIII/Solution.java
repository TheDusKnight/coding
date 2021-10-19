package leetcode._0437_PathSumIII;
import leetcode.TreeNode;

// recursion
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        
        // root或者非root的path sum
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode root, int sum) {
        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}

// time: O(n?) due to recursion
// space: O(n^2)