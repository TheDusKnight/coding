package leetcode.MicorsoftOnSite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Microsoft new grad interview 3rd round
// Trevor Zhong
public class Intervals {
    class EndPoint {
        int val;
        boolean isStart;
        int idx;

        public EndPoint (int val, boolean isStart, int idx) {
            this.val = val;
            this.isStart = isStart;
            this.idx = idx;
        }
    }

    public List<int[]> getTasks(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            throw new IllegalArgumentException("Invalid");
        
        List<EndPoint> points = constructEndPoints(intervals);
        Collections.sort(points, (o1, o2) -> {
            // if (o1.idx != o2.idx) {
            //     return o1.idx - o2.idx;
            // }
            // return o1.isStart ? 1 : -1;
            return o1.idx - o2.idx; // there is no tie problem
        });

        List<int[]> res = new ArrayList<>();
        int height = 0;
        for (int i = 0; i < points.size()-1; i++) {
            EndPoint point = points.get(i);
            int[] triple = new int[3];
            if (point.isStart) {
                height += point.val;
                triple[0] = height;
                triple[1] = point.idx;
                triple[2] = points.get(i+1).idx;
            } else {
                height -= point.val;
                triple[0] = height;
                triple[1] = point.idx;
                triple[2] = points.get(i+1).idx;
            }
            // remove zero range triple
            if (triple[1] != triple[2]) res.add(triple);
        }

        return res;
    }

    private List<EndPoint> constructEndPoints(int[][] intervals) {
        List<EndPoint> list = new ArrayList<>();
        for (int[] interval: intervals) {
            list.add(new EndPoint(interval[0], true, interval[1]));
            list.add(new EndPoint(interval[0], false, interval[2]));
        }

        return list;
    }

    public static void main(String[] args) {
        // int[][] inputs = new int[][] {{3,0,3}, {2,2,5}, {1,4,7}};
        // int[][] inputs = new int[][] {{3,0,3}, {2,2,5}, {1,3,7}};
        // int[][] inputs = new int[][] {{2,1,3}, {3,2,3}};
        // int[][] inputs = new int[][] {{2,1,3}, {3,1,2}};
        // int[][] inputs = new int[][] {{2,1,3}, {3,1,3}};
        // int[][] inputs = new int[][] {{2,1,3}};
        int[][] inputs = new int[][] {{2,1,3}, {3,3,5}};
        // int[][] inputs = new int[][] {};
        Intervals intervals = new Intervals();
        List<int[]> res = intervals.getTasks(inputs);
        for (int[] triple: res) {
            System.out.println(Arrays.toString(triple));
        }


    }
}

// time: O(n*log(n)). n is the number of intervals
// space: O(n)
