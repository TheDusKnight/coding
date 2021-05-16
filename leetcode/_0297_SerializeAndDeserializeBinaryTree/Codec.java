package leetcode._0297_SerializeAndDeserializeBinaryTree;
import leetcode.TreeNode;
import java.util.*;

// 面试考得挺多
// dfs pre-order
public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        rserialize(root);
        return sb.toString();
    }
    
    private void rserialize(TreeNode root) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        
        sb.append(String.valueOf(root.val));
        sb.append(",");
        rserialize(root.left);
        rserialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strArr));
        return rdeserialize(queue);
    }

    private TreeNode rdeserialize(Queue<String> l) {
        // bc
        if (l.peek().equals("null")) {
            l.poll();
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.poll()));
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
