package leetcode.LabelBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.TreeGenerator;
import leetcode.TreeNode;

public class Solution {
   public List<Integer> labelBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       int count = 1;

       while (!queue.isEmpty()) {
           TreeNode cur = queue.poll();
           res.add(count++);
           if (cur.left != null) queue.offer(cur.left);
           if (cur.right != null) queue.offer(cur.right);
       }
       return res;
   }



   public static void main(String[] args) {
       String data = "1,2,3,4,#,5,6";
       TreeNode root = TreeGenerator.deserialize(data);
       Solution sol = new Solution();
       System.out.println(sol.labelBinaryTree(root).toString());
   }
}
