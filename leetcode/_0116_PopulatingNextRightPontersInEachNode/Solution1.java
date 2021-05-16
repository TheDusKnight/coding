package leetcode._0116_PopulatingNextRightPontersInEachNode;

// Using previously established next pointers
public class Solution1 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
    
        Node leftMost = root;

        // when next level is not null
        while (leftMost.left != null) {
            Node head = leftMost;

            // when curr level still has next node
            while (head != null) {
                // connection 1
                head.left.next = head.right;

                // connection 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // go to next node
                head = head.next;
            }

            leftMost = leftMost.left;
        }
        return root;
    }
}