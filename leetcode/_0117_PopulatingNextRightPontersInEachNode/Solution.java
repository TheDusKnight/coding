package leetcode._0117_PopulatingNextRightPontersInEachNode;

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;

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