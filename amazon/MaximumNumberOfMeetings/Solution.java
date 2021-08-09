package amazon.MaximumNumberOfMeetings;

import java.util.Arrays;
import java.util.List;

// Greedy
public class Solution {
    public static int getMaximumMeetings(List<Integer> start, List<Integer> timeTaken) {
        // cc
        int maxMeetings = 1;
        int[][] times = new int[start.size()][2];
        for (int i = 0; i < start.size(); i++) {
            times[i] = new int[] {start.get(i), start.get(i) + timeTaken.get(i)};
        }
        // greedy sort by latest end time
        Arrays.sort(times, (a, b) -> (a[1] - b[1]));
        int curEnd = times[0][1];
        
        for (int i = 1; i < times.length; i++) {
            // if (times[i][0] == times[i-1][0]) {
            //     // curEnd = Math.min(times[i][1], times[i-1][1]);
            //     curEnd = Math.min(times[i][1], curEnd);
            //     continue;
            // }
            if (times[i][0] >= curEnd) {
                curEnd = times[i][1];
                maxMeetings++;
            }
        }
        return maxMeetings;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1,3,3,5,7);
        List<Integer> timeTaken = Arrays.asList(2,2,1,2,1);

        // List<Integer> start = Arrays.asList(1,1,5);
        // List<Integer> timeTaken = Arrays.asList(2,5,2);
        System.out.println(Solution.getMaximumMeetings(start, timeTaken));
    }
}

// time: O(N*log(N))