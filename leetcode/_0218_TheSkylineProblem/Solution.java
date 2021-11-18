package leetcode._0218_TheSkylineProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// intervals, sort by start and end
class Solution {
    class EndPoint implements Comparable<EndPoint> {
        int x, height;
        boolean isStart;
        
        public EndPoint(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(EndPoint that) {
            if (this.x != that.x) {
                return this.x - that.x;
            } else if (this.isStart && that.isStart) {
                return that.height - this.height;
            } else if (!this.isStart && !that.isStart) {
                return this.height - that.height;
            } else {
                return this.isStart ? -1 : 1;
            }
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // cc
        
        List<List<Integer>> res = new ArrayList<>();
        EndPoint[] points = generatePoints(buildings); // O(N)
        
        Arrays.sort(points); // O(N*log(N))
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1)); // store heights
        for (EndPoint point: points) { // O(N)
            if (point.isStart) {
                if ((maxHeap.isEmpty() || maxHeap.peek() < point.height))
                    res.add(Arrays.asList(point.x, point.height));
                maxHeap.offer(point.height); // O(log(N))
            } else {
                maxHeap.remove(point.height); // O(N)
                if (maxHeap.isEmpty() || point.height > maxHeap.peek()) {
                    res.add(Arrays.asList(point.x, maxHeap.isEmpty() ? 0 : maxHeap.peek()));
                }
            }
        }
        
        return res;
    }
    
    private EndPoint[] generatePoints(int[][] buildings) {
        EndPoint[] res = new EndPoint[buildings.length * 2];
        
        int j = 0;
        for (int i = 0; i < buildings.length; i++) {
            res[j++] = new EndPoint(buildings[i][0], buildings[i][2], true);
            res[j++] = new EndPoint(buildings[i][1], buildings[i][2], false);
        }
        
        return res;
    }
}

// time: O(N^2); space: O(N);
