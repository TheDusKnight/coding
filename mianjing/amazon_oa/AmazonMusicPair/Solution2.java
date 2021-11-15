package mianjing.amazon_oa.AmazonMusicPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public static List<Integer> findSongs(int rideDuration, List<Integer> songDurations) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < songDurations.size(); i++) {
            Integer checkKey = map.get(rideDuration - 30 - songDurations.get(i));
            if (checkKey != null)
                res.add(Arrays.asList(checkKey, i));
            map.putIfAbsent(songDurations.get(i), i);
        }

        if (res.size() == 1)
            return res.get(0);
        if (res.size() > 1) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < res.size(); i++) {
                int localMin = Math.min(songDurations.get(res.get(i).get(0)), songDurations.get(res.get(i).get(1)));
                if (min > localMin) {
                    min = localMin;
                    minIdx = i;
                }
            }
            return res.get(minIdx);
        }
        return Arrays.asList(-1, -1);
    }

    public static void main(String[] args) {
        List<Integer> songDurations = Arrays.asList(100,180,40,120,10);
        int rideDuration = 250;
        System.out.println(Solution2.findSongs(rideDuration, songDurations));
    }
}
