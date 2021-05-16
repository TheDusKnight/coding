package leetcode._0116_PopulatingNextRightPontersInEachNode;
import java.util.*;

// Level Order Traversal
public class Solution {
  public Node connect(Node root) {
    if (root == null) return root;

    Queue<Node> Q = new LinkedList<>();
    Q.add(root);

    while (!Q.isEmpty()) {
      int size = Q.size();
      for (int i = 0; i < size; i++) {
        Node curr = Q.poll();
        
        if (i < size - 1) {
          curr.next = Q.peek();
        }

        if (curr.left != null) {
          Q.add(curr.left);
        }
        if (curr.right != null) {
          Q.add(curr.right);
        }
      }
    }
    return root;
  }
}
