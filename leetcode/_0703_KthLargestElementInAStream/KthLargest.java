package leetcode._0703_KthLargestElementInAStream;

import java.util.PriorityQueue;
import java.util.Queue;

// minHeap find kth largest
class KthLargest {
    Queue<Integer> minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        // cc
        
        minHeap = new PriorityQueue<>((o1, o2) -> (o1 - o2));
        this.k = k;
        
        for (int num: nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) minHeap.poll();
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();
        
        return minHeap.peek();
    }
}

// time: 初始化 O(n*log(k)). add O(log(k)); space: O(k);

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
