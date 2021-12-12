package leetcode._1615_MaximalNetworkRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// graph
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        // cc
        
        Set<Integer>[] graph = buildGraph(roads, n);
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count1 = graph[i].size();
                int count2 = graph[j].size();
                int curCount = graph[i].contains(j) ? count1 + count2 - 1 : count1 + count2;
                max = Math.max(max, curCount);
            }
        }
        
        return max;
    }
    
    private Set<Integer>[] buildGraph(int[][] roads, int n) {
        Set<Integer>[] graph = new Set[n];
        Arrays.setAll(graph, ele -> new HashSet<>());
        
        for (int[] road: roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        return graph;
    }
}

// time: O(n^2); space: O(n^2);
