package leetcode._0297_SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

// bfs; Same with TreeGenerator
public class Codec1 {
    // Encodes a tree to a single string
    public static String serialize(TreeNode root) {
        if (root == null)
            return "#,";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#,");
            } else {
                sb.append(cur.val + ",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String ss[] = data.split(",");
        if (ss == null || ss.length == 0) {
            throw new IllegalArgumentException();
        }
        if (ss.length == 1 && ss[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(ss[0])); // ss[0]一定为数字因为ss不是空树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < ss.length) { // 或者!queue.isEmpty()
            TreeNode cur = queue.poll();
            TreeNode left = ss[i].equals("#") ? null : new TreeNode(Integer.valueOf(ss[i]));
            // 防止越界
            TreeNode right = (++i >= ss.length || ss[i].equals("#") ? null : new TreeNode(Integer.valueOf(ss[i])));
            cur.left = left;
            cur.right = right;
            // 走到最后，左右为null，queue不会offer，queue变成空，并且i也移动到最后一位
            if (left != null)
                queue.offer(left);
            if (right != null)
                queue.offer(right);
            i++; // 指针往后移动一位
        }
        return root;
    }
}

// time: O(n); space: size + #('#') + #(',') = size + size + 2size = O(4n);)
