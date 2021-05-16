package leetcode;


// 以递增方式打印
public class SearchRange {
    // public void searchRange(TreeNode root, int k1, int k2) {
    //     if (root == null) return;
    //     searchRange(root.left, k1, k2);
    //     if (k1 <= root.val && root.val <= k2) System.out.println(root.val);
    //     searchRange(root.right, k1, k2);
    // }
    
    // time: O(n)
    
    public static void searchRange(TreeNode root, int k1, int k2) {
        if (root == null) return;

        if (root.val > k1) searchRange(root.left, k1, k2);
        if (k1 <= root.val && root.val <= k2) System.out.println(root.val);
        if (root.val < k2) searchRange(root.right, k1, k2);
    }

    // time: O(log(n))
}
