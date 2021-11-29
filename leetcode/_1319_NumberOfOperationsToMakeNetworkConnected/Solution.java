package leetcode._1319_NumberOfOperationsToMakeNetworkConnected;

import java.util.ArrayList;
import java.util.List;

// dfs需要查环不需要加memo类似number of island
class Solution {
   public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] connection: connections) {
            graph[connection[0]].add(connection[1]);
            graph[connection[1]].add(connection[0]);
        }
        
        int components = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            components += dfs(graph, visited, i);
        }
        
        return components - 1;
    }
    
    private int dfs(List<Integer>[] graph, boolean[] visited, int u) {
        if (visited[u]) return 0;
        
        visited[u] = true;
        for (int v: graph[u]) dfs(graph, visited, v);
        
        return 1;
    }
}

// time: O(n+m); space: O(n*m);
