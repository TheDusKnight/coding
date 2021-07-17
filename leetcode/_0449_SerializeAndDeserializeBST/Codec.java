package leetcode._0449_SerializeAndDeserializeBST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// dfs preorder + inorder
// 可以用297 bfs/dfs做但空间复杂度不好
public class Codec {
    StringBuilder sb = new StringBuilder();
    int[] pre;
    Map<Integer, Integer> map = new HashMap<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return sb.toString();
    }
    
    // dfs preorder
    private void dfsSerialize(TreeNode root) {
        if (root == null) {
            return;
        }
        
        sb.append(root.val + ",");
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 注意处理一下cc因为inorder+preorder做法string不包含"#"
        if (data == null || data.length() == 0)
            return null;
        // 预处理生成pre和in
        String[] ss = data.split(",");
        int[] pre = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            pre[i] = Integer.valueOf(ss[i]);
        }
        int[] in = Arrays.copyOf(pre, pre.length);
        Arrays.sort(in);
        
        this.pre = pre;
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return helper(0, 0, in.length-1);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd) {
        if (preStart >= pre.length || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(pre[preStart]);
        int inIndex = map.get(root.val);
        root.left = helper(preStart+1, inStart, inIndex-1);
        root.right = helper(preStart+(inIndex-inStart)+1, inIndex+1, inEnd);
        return root;
    }
}

// time: O(n*log(n)), space: O(size+#(,)) = O(2*size) = O(2n)

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
