package leetcode._0056_MergeIntervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0) return null;
        
        Collections.sort(Arrays.asList(intervals), (a, b) -> a[0] - b[0]);
        
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval: intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
