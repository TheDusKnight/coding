package leetcode._0797_AllPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// graph遍历
class Solution {
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) return res;
        
        n = graph.length;
        Map<Integer, Integer> map = new HashMap<>();
        dfs(graph, res, map, 0);
        
        return res;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> res, Map<Integer, Integer> map, int v) {
        if (v == n-1) recover(res, map, v);
        
        for (int neighbor: graph[v]) {
            map.put(neighbor, v);
            dfs(graph, res, map, neighbor);
        }
    }
    
    private void recover(List<List<Integer>> res, Map<Integer, Integer> map, int v) {
        List<Integer> path = new LinkedList<>();
        
        int cur = v;
        path.add(0, cur);
        while (cur != 0) {
            cur = map.get(cur);
            path.add(0, cur);
        }
        
        res.add(path);
    }
}

// time: O(2^n * n). 2^n指从start到end所有可能的path数量, n指dfs最多走n步找到一个path;
// space: O(2^n (number of paths cost) * n (each path cost));
