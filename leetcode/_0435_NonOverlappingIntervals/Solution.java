package leetcode._0435_NonOverlappingIntervals;

import java.util.Arrays;

// Greedy
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // cc
        int minRemove = 0;
        // greedy way按早最早结束排序
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int curEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= curEnd) { // 能够加入
                curEnd = intervals[i][1];
            } else { // 区间开始时间小于上一个有效区间的结束时间，不能加入
                minRemove++;
            }
        }
        
        return minRemove;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,2}, {1,3}, {1,3}, {2,4}, {3,5}, {3,5}, {4,6}};
        Solution sol = new Solution();
        System.out.println(sol.eraseOverlapIntervals(intervals));
    }
}

// time: O(n*log(n))