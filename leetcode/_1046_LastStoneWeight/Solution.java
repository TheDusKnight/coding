package leetcode._1046_LastStoneWeight;

import java.util.PriorityQueue;
import java.util.Queue;

// Heap
// 还有一种解法是count sort没写
class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int stone: stones) maxHeap.offer(stone);
        
        while (!maxHeap.isEmpty()) {
            if (maxHeap.size() == 1) return maxHeap.poll();
            
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if (y > x) {
                maxHeap.offer(y - x);
            } else { }
        }
        
        return 0;
    }
}

// time: O(N + N*log(N)); space: O(N);
