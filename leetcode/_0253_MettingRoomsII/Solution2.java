package leetcode._0253_MettingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// PriorityQueue标准答案
class Solution2 {
    public int minMeetingRooms(int[][] intervals) {
        // cc
        
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        minHeap.offer(intervals[0][1]);
        
        for (int i = 1; i < intervals.length; i++) {
            int minEnd = minHeap.peek(); // 结束时间最快的meeting
            if (minEnd <= intervals[i][0]) {
                minHeap.poll();
            }
            // 如果有重合，新开一个room的end time放入heap
            // 如果没有重合更新end time为intervals[i][1]因为minEnd <= intervals[i][0]所以minEnd < intervals[i][1]
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}

// time: O(N*log(N) for sort + N*log(N) for extract min)
