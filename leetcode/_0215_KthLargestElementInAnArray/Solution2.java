package leetcode._0215_KthLargestElementInAnArray;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution2 {
    // minHeap
    public int findKthLargest(int[] nums, int k) {
        // cc
        Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int num: nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}

// time: O(n*log(k)); space: O(k)
