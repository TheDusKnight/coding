package leetcode._0965_UnivaluedBinaryTree;
import java.util.*;

import leetcode.TreeNode;
// import 

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        int univalue = root.val;
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {  // 注意cur有可能为null
                if (cur.val != univalue) return false;
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
