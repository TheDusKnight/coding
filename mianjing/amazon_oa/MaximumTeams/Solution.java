package mianjing.amazon_oa.MaximumTeams;

import java.util.Arrays;

public class Solution {
    public static int getTeams(int[] skills, int teamSize, int maxDiff) {
        Arrays.sort(skills);
        int n = teamSize - 1;
        int count = 0;
        for (int i = 0; i < skills.length - n; i++) {
            int start = skills[i];
            int end = skills[i+n];
            if (end - start <= maxDiff) {
                count++;
                i += n;
            }
        }
        return count;
    }
}
