package leetcode._0973_KClosestPointsToOrigin;

import java.util.PriorityQueue;
import java.util.Queue;

// maxHeap
class Solution2 {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0]+p2[1]*p2[1]-p1[0]*p1[0]-p1[1]*p1[1]));
        for (int[] point: points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
