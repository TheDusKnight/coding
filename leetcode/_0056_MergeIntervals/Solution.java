package leetcode._0056_MergeIntervals;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

// Intervals
public class Solution {
    // private class IntervalComparator implements Comparator<int[]> {
    //     @Override
    //     public int compare(int[] a, int[] b) {
    //         return a[0] - b[0];
    //     }
    // }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return null;
        // Comparator第一种写法，Collections操作的必须是List type
        // Collections.sort(Arrays.asList(intervals), new IntervalComparator());

        // Comparator第二种写法
        // Collections.sort(Arrays.asList(intervals), new Comparator<int[]>(){
        //     public int compare(int[] a, int[] b) {
        //         return a[0] - b[0];
        //     }
        // });
        
        // Comparator第三种写法
        Collections.sort(Arrays.asList(intervals), (a, b) -> a[0] - b[0]);

        LinkedList<int[]> merged = new LinkedList<>(); // 必须写全否则没发使用getLast
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) { // ex [0,2] and [4, 6]
                merged.add(interval); // 如果没法合并，就加进去
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]); // ex [0,2] and [1,3]
            }
        }

        return merged.toArray(new int[merged.size()][]); // toArray传入新的array类型与size
    }
}

// time: O(n*log(n)); space: O(n)