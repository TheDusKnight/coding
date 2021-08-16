package leetcode._0785_IsGraphBipartite;

// 图的遍历dfs写法
// dfs 一不通百不通
class Solution2 {
    public boolean isBipartite(int[][] graph) {
        // cc
        
        int n = graph.length;
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            // This graph might be a disconnected graph. So check each unvisited node.
            if (mark[i] == 0 && !dfs(graph, mark, 1, i))
                return false;
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] mark, int color, int cur) {
        if (mark[cur] != 0)
            return mark[cur] == color;
        
        mark[cur] = color;
        int[] neighbors = graph[cur];
        for (int neighbor: neighbors) {
            if (!dfs(graph, mark, -color, neighbor))
                return false;
        }
        return true;
    }
}

// time: O(N + E), N is the number of nodes int the graph, E is the number of edges.
