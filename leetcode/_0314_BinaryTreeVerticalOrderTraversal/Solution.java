package leetcode._0314_BinaryTreeVerticalOrderTraversal;
import leetcode.TreeNode;
import leetcode.Pair;
import java.util.*;

public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root, Map map) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int column = 0;
        queue.offer(new Pair<>(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (!columnTable.containsKey(column)) {
                columnTable.put(column, new ArrayList<Integer>());
            }
            columnTable.get(column).add(root.val);

            if (root.left != null) queue.offer(new Pair<>(root.left, column - 1));
            if (root.right != null) queue.offer(new Pair<>(root.right, column + 1));
        }

        List<Integer> sortedKeys = new ArrayList<Integer> (columnTable.keySet());
        Collections.sort(sortedKeys);
        for (int k : sortedKeys) {
            output.add(columnTable.get(k));
        }
        return output;
    }
}
// time: O(n + n*log(n))
// space: O(n)