package leetcode._0215_KthLargestElementInAnArray;
import java.util.*;

// max heap
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) throw new RuntimeException("msg");
        Queue<Integer> queue = new PriorityQueue<Integer> ((n1, n2) -> (n2 - n1));
        
        for (int num : nums) {
            queue.add(num);
        }
        
        while (k-- > 1) {
            queue.poll();
        }
        
        return queue.poll();
    }
}
