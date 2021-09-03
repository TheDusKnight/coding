package leetcode._0173_BinarySearchTreeIterator;

import java.util.Stack;

import leetcode.TreeNode;

class BSTIterator2 {
    Stack<TreeNode> stack;
    
    public BSTIterator2(TreeNode root) {
        stack = new Stack<>();
        
        leftInOrder(root);

    }
    
    private void leftInOrder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode cur = stack.pop();
        int res = cur.val;
        
        // if (cur.right != null) {
            leftInOrder(cur.right); // 往右拐一个防止重复遍历
        // }
        
        return res;
    }
    
    public boolean hasNext() {
        return stack.isEmpty() == true ? false : true;
    }
}

// time: average O(1); space: O(h);
