package leetcode._0215_KthLargestElementInAnArray;
import java.util.PriorityQueue;
import java.util.Queue;

// minHeap
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        // cc
        
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        for (int i: nums) {
            minHeap.offer(i);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        return minHeap.poll();
    }
}

// time: Heapify + (N-k)*ExtractMin() = k + (N-k)*log(k) = N*log(k); space: O(K);
