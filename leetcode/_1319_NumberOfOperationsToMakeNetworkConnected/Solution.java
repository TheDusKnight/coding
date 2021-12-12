package leetcode._1319_NumberOfOperationsToMakeNetworkConnected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// graph上的number of islands
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (n < 0 || connections == null || connections[0] == null || connections.length == 0 || connections[0].length != 2)
            throw new IllegalArgumentException();
        if (n <= 1) return 0;
        
        int cables = connections.length;
        if (cables < n-1) return -1;
        
        int count = 0;
        List<Integer>[] graph = buildGraph(connections, n);
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }
        
        return count-1;
    }
    
    private List<Integer>[] buildGraph(int[][] connections, int n) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, ele -> new ArrayList<>()); // 没connection的点也初始化
        
        for (int i = 0; i < connections.length; i++) {
            graph[connections[i][0]].add(connections[i][1]);
            // 必须是双向否则会漏点！！
            graph[connections[i][1]].add(connections[i][0]);
        }
        
        return graph;
    }
    
    private void dfs(List<Integer>[] graph, boolean[] visited, int idx) {
        if (visited[idx]) return;
        
        visited[idx] = true;
        List<Integer> nexts = graph[idx];
        // if (nexts == null) return; // 所有点都初始化过了
        for (int next: nexts) {
            dfs(graph, visited, next);
        }
    }
}

// time: O(V+E) = O(n + k) k是connections的长度；
// space: O(n*k); graph的space
