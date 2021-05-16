package leetcode._0098_ValidateBinarySearchTree;
import leetcode.TreeNode;

// use min max recursion from bottom to top
// bottom up,非常难!!!
class Solution3 {
    public boolean isValidBST(TreeNode root) {
        // cc
        return isBST(root, null, null) == null ? false : true;
    }
    
    private Integer[] isBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        // base case
        if (root == null) return new Integer[] {null, null};
        
        Integer[] leftBound = isBST(root.left, lowerBound, upperBound);
        Integer[] rightBound = isBST(root.right, lowerBound, upperBound);
        
        // 左边或者右边不valid
        if (leftBound == null || rightBound == null) return null;
        
        // 左右都是null,返回叶子结点的值
        if (leftBound[1] == null && rightBound[0] == null)
            return new Integer[] {root.val, root.val};
        // 左null
        if (leftBound[1] == null) {
            if (root.val >= rightBound[0]) return null;
            else return new Integer[] {root.val, rightBound[1]};
        }
        // 右null
        if (rightBound[0] == null) {
            if (root.val <= leftBound[1]) return null;
            else return new Integer[] {leftBound[0], root.val};
        }
        // 左右都不是null
        if (root.val <= leftBound[1] || root.val >= rightBound[0]) return null;
        // 取左边最小值和右边最大值
        return new Integer[] {leftBound[0], rightBound[1]};
    }
}
