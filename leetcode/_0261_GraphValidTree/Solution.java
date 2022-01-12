package leetcode._0261_GraphValidTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// dfs无向图查环
class Solution {
    int edgeNum;
    List<Integer>[] graph;
    int[] status;
    public boolean validTree(int n, int[][] edges) {
        // cc
        
        edgeNum = edges.length;
        if (n != edgeNum+1) return false;
        
        graph = buildGraph(n, edges);
        status = new int[n];
        for (int i = 0; i < n; i++)
            if (checkCycle(i, -1)) return false;
        
        return true;
    }
    
    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, ele -> new ArrayList<>());
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        return graph;
    }
    
    private boolean checkCycle(int idx, int parent) {
        if (status[idx] == 1) return true;
        if (status[idx] == 2) return false;
        
        status[idx] = 1;
        List<Integer> nexts = graph[idx]; // nexts一定不为空
        for (int next: nexts) {
            if (next == parent) continue;
            if (checkCycle(next, idx)) return true;
        }
        status[idx] = 2;
        return false;
    }
}

// time: O(n) n is input n; space: O()
