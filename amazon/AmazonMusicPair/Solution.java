package amazon.AmazonMusicPair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 不好
public class Solution {
    public static List<Integer> musicPair(List<Integer> songDurations, int rideDuration) {
        // cc
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < songDurations.size(); i++) {
            Integer checkKey = map.get(rideDuration-30-songDurations.get(i));
            if (checkKey != null) return Arrays.asList(i, checkKey);

            map.put(songDurations.get(i), i);
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        List<Integer> songDurations = Arrays.asList(100,180,40,120,10);
        int rideDuration = 250;
        System.out.println(Solution.musicPair(songDurations, rideDuration));
    }
}

// time: O(n); space: O(n)
