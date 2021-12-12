package leetcode._0310_MinimumHeightTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// graph, 不断trim out leave layer直到剩下1或2个node
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (n == 1) return Arrays.asList(0);
        if (n != edges.length + 1) return leaves;
        
        List<Integer>[] graph = buildGraph(edges, n);
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (Integer leave: leaves) {
                int parent = graph[leave].get(0);
                graph[parent].remove(leave);
                if (graph[parent].size() == 1)
                    newLeaves.add(parent);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
    
    private List<Integer>[] buildGraph(int[][] edges, int n) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, ele -> new ArrayList<>());
        
        for (int[] edge: edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        return graph;
    }
}

// time O(N); space: O(N);
