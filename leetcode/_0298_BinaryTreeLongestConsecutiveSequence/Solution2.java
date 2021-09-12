package leetcode._0298_BinaryTreeLongestConsecutiveSequence;

import leetcode.TreeNode;

// 自写recursion
class Pair<K,V> {
    K k;
    V v;
    
    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }
}

class Solution2 {
    int res = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root);
        return res;
    }
    
    private Pair<Integer, Integer> dfs(TreeNode root) {
        if (root == null) return new Pair<>(null, 0);
        
        Pair<Integer, Integer> left = dfs(root.left);
        Pair<Integer, Integer> right = dfs(root.right);
        
        int longest = 0;
        if (left.k != null && left.k - 1 == root.val) {
            longest = Math.max(longest, left.v);
        }
        if (right.k != null && right.k - 1 == root.val) {
            longest = Math.max(longest, right.v);
        }
        res = Math.max(res, longest+1);
        return new Pair<Integer, Integer>(root.val, longest+1);
    }
}

// recursion优化
class Solution3 {
    int longest = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        dfs(root);
        return longest;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        int curMax = 0;
        if (root.left != null && root.left.val - 1 == root.val) {
            curMax = Math.max(curMax, left);
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            curMax = Math.max(curMax, right);
        }
        longest = Math.max(longest, curMax+1);
        return curMax+1;
    }
}
