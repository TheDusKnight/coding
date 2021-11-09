package leetcode._0215_KthLargestElementInAnArray;
import java.util.PriorityQueue;
import java.util.Queue;

// maxHeap
class Solution3 {
    public int findKthLargest(int[] nums, int k) {
        // cc
        
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i: nums) {
            maxHeap.offer(i);
        }
        
        while (!maxHeap.isEmpty() && k-- > 1) maxHeap.poll();
        return maxHeap.poll();
    }
}

// time: Heapify+k*ExtractMax() = O(N + k*log(N)); space: O(N);
