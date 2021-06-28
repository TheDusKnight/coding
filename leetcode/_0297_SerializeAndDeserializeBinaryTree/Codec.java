package leetcode._0297_SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import leetcode.TreeNode;

// dfs 面试高频
public class Codec {
    StringBuilder sb = new StringBuilder();
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfsSerialize(root);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(String.valueOf(root.val) + ",");
        dfsSerialize(root.left);
        dfsSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Queue<String> l) {
        String cur = l.poll();
        if (cur.equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(cur));
        root.left = dfsDeserialize(l);
        root.right = dfsDeserialize(l);
        return root;
    }

    // 用String[]替代queue，基本逻辑就是每到下一层dfs idx都右移一位并且返回到上一层时idx不还原
    // public TreeNode deserialize(String data) {
    // String[] ss = data.split(",");
    // return dfsDeserialize(ss);
    // }

    // private TreeNode dfsDeserialize(String[] l) {
    // String cur = l[idx];
    // if (cur.equals("#"))
    // return null;

    // TreeNode root = new TreeNode(Integer.valueOf(cur));
    // idx++; // 根到左idx右移一位
    // root.left = dfsDeserialize(l);
    // idx++; // 左到右idx右移一位
    // root.right = dfsDeserialize(l);
    // return root;
    // }
}
// time: O(n)

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
