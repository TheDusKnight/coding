package leetcode._0215_KthLargestElementInAnArray;
import java.util.*;

// min heap
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> (n1 - n2));
        
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }
}
// time: O(n + k*log(n))
