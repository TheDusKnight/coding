package leetcode;
import java.util.*;

public class BinaryTreeDrawer { // LC297
    
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
