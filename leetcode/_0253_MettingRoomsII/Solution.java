package leetcode._0253_MettingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// PriorityQueue
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // cc
        
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        // minHeap.offer(intervals[0]);
        
        for (int i = 0; i < intervals.length; i++) {
            if (minHeap.isEmpty()) {
                minHeap.offer(intervals[i]);
                continue;
            }
            int[] min = minHeap.peek(); // 结束时间最快的meeting
            if (min[1] <= intervals[i][0]) {
                min[1] = Math.max(min[1], intervals[i][1]);
                minHeap.poll();
                minHeap.offer(min);
                // minHeap.offer(intervals[i]);
            } else {
                minHeap.offer(intervals[i]);
            }
        }
        return minHeap.size();
    }
}

// time: O(N*log(N) for sort + N*log(N) for extract min)
