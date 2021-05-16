package leetcode;
import java.util.*;

class LeafNodeOrderTraversal {
    public List<List<Integer>> leftNodes(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int height = getHeight(root, map);
        // System.out.println(height);
        // System.out.println(map);
        
		// for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
		// 	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		// res.add(entry.getValue());
		// }
        
        for (int i = 1; i <= height; i++) {
            res.add(map.get(i));
        }

        return res;
    }
    
    private int getHeight(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left, map);
        int rightHeight = getHeight(root.right, map);
        
        int curHeight = Math.max(leftHeight, rightHeight) + 1;
        if (!map.containsKey(curHeight)) {
            map.put(curHeight, new ArrayList<Integer>());
        }
        map.get(curHeight).add(root.val);
        return curHeight;
    }
}
