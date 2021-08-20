package leetcode._0252_MeetingRooms;

import java.util.Arrays;

// Array + sort
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;
        
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int cur = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < cur) return false;
            cur = intervals[i][1];
        }
        return true;
    }
}

// time: O(Nlog(N));
