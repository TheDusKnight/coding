package leetcode._0253_MettingRoomsII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 算法哥sort by start and end，注意tie的情况！！！！
class Solution2 {
    class EndPoint implements Comparable<EndPoint> {
        int val;
        boolean isStart;

        public EndPoint(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(EndPoint that) {
            if (this.val != that.val) {
                return this.val - that.val;
            } else {
                return this.isStart == true ? 1 : -1;
            }
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        // cc

        List<EndPoint> list = loadPoints(intervals);
        Collections.sort(list); // 另一种方法是使用lambda表达式

        int count = 0, max = 0;
        for (EndPoint point : list) {
            if (point.isStart) {
                count++;
                max = Math.max(max, count);
            } else
                count--;
        }

        return max;
    }

    private List<EndPoint> loadPoints(int[][] intervals) {
        List<EndPoint> list = new ArrayList<>();

        for (int[] pair : intervals) {
            list.add(new EndPoint(pair[0], true));
            list.add(new EndPoint(pair[1], false));
        }

        return list;
    }
}