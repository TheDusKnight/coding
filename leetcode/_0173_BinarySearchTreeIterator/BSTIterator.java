package leetcode._0173_BinarySearchTreeIterator;

import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

// inorder arrayList
class BSTIterator {
    List<Integer> list;
    int counter;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inOrder(list, root);
        counter = 0;
    }
    
    private void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }
    
    public int next() {
        return list.get(counter++);
    }
    
    public boolean hasNext() {
        return counter < list.size() ? true : false;
    }
}

// time: O(1); space: O(N);
