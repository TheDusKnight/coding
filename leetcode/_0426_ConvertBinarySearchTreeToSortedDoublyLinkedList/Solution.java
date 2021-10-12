package leetcode._0426_ConvertBinarySearchTreeToSortedDoublyLinkedList;

// recursion传递child的首尾，cur node拼接再向上传递
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        Node[] headTail = recursion(root);
        headTail[0].left = headTail[1];
        headTail[1].right = headTail[0];
        
        return headTail[0];
    }
    
    private Node[] recursion(Node root) {
        if (root == null) return null;
        
        Node[] left = recursion(root.left);
        Node[] right = recursion(root.right);
        
        if (left == null && right == null) {
            return new Node[] {root, root};
        }
        
        if (left != null) {
            left[1].right = root;
            root.left = left[1];
        }
        if (right != null) {
            right[0].left = root;
            root.right = right[0];
        }
        
        Node[] ret = new Node[2];
        ret[0] = left != null ? left[0] : root;
        ret[1] = right != null ? right[1] : root;
        return ret;
    }
}
