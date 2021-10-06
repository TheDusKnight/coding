package leetcode._0244_ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// HashMap存每个word所有出现过的位置
class WordDistance {
    Map<String, List<Integer>> map;
    int n;
    public WordDistance(String[] wordsDict) {
        // cc
        
        n = wordsDict.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(wordsDict[i])) map.put(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        // cc
        
        List<Integer> idx1s = map.get(word1);
        List<Integer> idx2s = map.get(word2);
        int shortest = n;
        int l1 = 0, l2 = 0;
        
        // 暴力找到所有可能的组合更新shortest
        // for (int idx1: idx1s) {
        //     for (int idx2: idx2s) {
        //         shortest = Math.min(shortest, Math.abs(idx1 - idx2));
        //     }
        // }
        
        // idx1s和idx2s是sorted，谁小移谁，尝试将shortest更新得更小
        while (l1 < idx1s.size() && l2 < idx2s.size()) {
            shortest = Math.min(shortest, Math.abs(idx1s.get(l1) - idx2s.get(l2)));
            if (idx1s.get(l1) < idx2s.get(l2)) {
                l1++;
            } else if (idx2s.get(l2) < idx1s.get(l1)) {
                l2++;
            }
        }
        
        return shortest;
    }
}

// time: O(K1 * K2) -> O(Math.min(K1, K2)). K1 and K2 is the frequency of word1 and word2 in wordsDict; space: O(N)

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */