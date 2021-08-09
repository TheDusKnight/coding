package leetcode._0937_ReorderDataInLogFiles;

import java.util.Arrays;

// sort compare
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            int s1SpaceIdx = s1.indexOf(' ');
            int s2SpaceIdx = s2.indexOf(' ');
            char s1FirstChar = s1.charAt(s1SpaceIdx + 1);
            char s2FirstChar = s2.charAt(s2SpaceIdx + 1);

            if (s1FirstChar <= '9') {
                if (s2FirstChar <= '9')
                    return 0;
                else return 1;
            }
            if (s2FirstChar <= '9') {
                return -1;
            }
            String s1After = s1.substring(s1SpaceIdx + 1);
            String s2After = s2.substring(s2SpaceIdx + 1);
            int check = s1After.compareTo(s2After);
            if (check == 0) {
                String s1Before = s1.substring(0, s1SpaceIdx);
                String s2Before = s2.substring(0, s2SpaceIdx);
                return s1Before.compareTo(s2Before);
            }
            return check;
        });
        return logs;
    }
}