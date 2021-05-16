package leetcode._0103_BinaryTreeZigzagLevelOrderTraversal;
import java.util.*;
import leetcode.TreeNode;

// bfs deque
public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int isEven = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (isEven == 0) {
                    list.add(cur.val);
                } else {
                    list.addFirst(cur.val);
                }

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            isEven = (isEven + 1) % 2;
            res.add(list);
        }
        return res;
    }
}
