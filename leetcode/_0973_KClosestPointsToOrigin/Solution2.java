package leetcode._0973_KClosestPointsToOrigin;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0]+p2[1]*p2[1]-p1[0]*p1[0]-p1[1]*p1[1]));
        for (int[] point: points) {
            queue.offer(point);
            if (queue.size() > k)
                queue.poll();
        }
        
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
