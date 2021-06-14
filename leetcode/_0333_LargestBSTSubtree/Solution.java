package leetcode._0333_LargestBSTSubtree;

import leetcode.TreeNode;

public class Solution {
    // dfs recursion return class
    private class Res {
        public int min, max, size;
        
        public Res(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    
    private int maxSize = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return maxSize;
    }
    
    private Res dfs (TreeNode root) {
        if (root == null) {
            // min, max初始化可以是任意值
            return new Res(0, 0, 0);
        }
        
        Res left = dfs(root.left);
        Res right = dfs(root.right);
        int size = 1;
        // 先判断子树是否都是bst
        if (left == null || right == null) 
            return null;
        // 再判断当前dfs能否拼成bst，如果能则更新size和maxSize
        if ((left.size == 0 || left.max < root.val) && (right.size == 0 || right.min > root.val)) {
            size = left.size + right.size + 1;
            maxSize = Math.max(size, maxSize);
        } else {
            return null; // 当前层check bst失败返回null
        }
        // 如果left为空，root.val为最小值
        // 如果right为空，root.val为最大值
        // 如果size为0，min max为root.val
        int min = (left.size > 0 ? left.min : root.val);
        int max = (right.size > 0 ? right.max : root.val);
        return new Res(min, max, size);
    }
}

// time: O(n)
