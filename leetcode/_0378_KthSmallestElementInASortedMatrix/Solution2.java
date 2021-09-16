package leetcode._0378_KthSmallestElementInASortedMatrix;

import java.util.PriorityQueue;
import java.util.Queue;

// store Math.min(row, k) element from each row to minHeap and poll k
// better than bfs + minHeap
class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        // cc
        
        int row = matrix.length, col = matrix[0].length;
        Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> (matrix[o1/col][o1%col] - matrix[o2/col][o2%col]));
        for (int i = 0; i < Math.min(row, k); i++) {
            minHeap.offer(i*col + 0);
        }
        
        int cur = minHeap.peek();
        while (k-- > 0) {
            cur = minHeap.poll();
            int i = cur / col;
            int j = cur % col;
            
            if (j < col-1) {
                minHeap.offer(i*col + (j+1));
            }
        }
        return matrix[cur/col][cur%col];
    }
}

// time: O(Math.min(row, k) + k*log(Math.min(row, k))); space: O(Math.min(row, k)) for heap
