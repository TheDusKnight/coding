package leetcode._0426_ConvertBinarySearchTreeToSortedDoublyLinkedList;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


// in-order recursion similar LC114
public class Solution2 {
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        // cc
        if (root == null) return null;
        
        inOrder(root);
        // 最后首尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inOrder(Node node) {
        // base case
        if (node == null) return;

        inOrder(node.left);
        // do sth
        if (pre != null) pre.right = node;
        else head = node;
        node.left = pre;

        pre = node; // pre++
        inOrder(node.right); // node++
    }
}
