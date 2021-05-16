package leetcode._0078_Subsets;
import java.util.*;

// 第一类搜索树bfs写法
class Solution4 {
    public List<List<Integer>> subsets(int[] nums) {
        // cc
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        
        int length = nums.length;
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        queue.offer(new ArrayList<>(temp));
        
        int col;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size-- > 0) {
                temp = queue.poll();
                result.add(new ArrayList<>(temp));
                
                if (temp.size() == 0) {
                    col = 0;
                }
                else {
                    col = temp.get(temp.size() - 1);
                    col = indexOf(nums, col) + 1;
                }
                
                for (int i = col; i < length; i++) {
                    temp.add(nums[i]);
                    queue.offer(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return result;
    }
    
    private int indexOf(int[] nums, int num) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == num) return i;
        }
        return -1;
    }
}