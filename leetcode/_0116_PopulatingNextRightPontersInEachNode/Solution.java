package leetcode._0116_PopulatingNextRightPontersInEachNode;
import java.util.LinkedList;
import java.util.Queue;

// BFS
class Solution {
  public Node connect(Node root) {
      if (root == null) return root;
      
      Queue<Node> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          while (size-- > 0) {
              Node cur = queue.poll();
              if (size != 0) cur.next = queue.peek();
              if (cur.left != null) queue.offer(cur.left);
              if (cur.right != null) queue.offer(cur.right);
          }
      }
      
      return root;
  }
}

// time: O(N); space: O(N);
