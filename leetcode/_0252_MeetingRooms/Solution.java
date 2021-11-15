package leetcode._0252_MeetingRooms;

import java.util.Arrays;

// interval sort by start
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
}

// |-----|
//     |-----|

// |-----|
//         |------|

// time: O(Nlog(N));