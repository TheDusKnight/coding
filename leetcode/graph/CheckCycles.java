package leetcode.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Status {
    VISITED,
    VISITING,
    INIT;
}

public class CheckCycles {
    public boolean checkCycles(Map<Integer, List<Integer>> graph) {
        // cc

        Map<Integer, Status> stMap = new HashMap<>();
        // stMap初始化？
        for (int cur: graph.keySet()) {
            if (dfs(graph, stMap, cur)) return true;
        }

        return false;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, Map<Integer, Status> stMap, int cur) {
        Status status = stMap.get(cur);
        if (status == Status.VISITED) return false; // pruning
        if (status == Status.VISITING) return true; // 使用visited查环
        
        stMap.put(cur, Status.VISITING);
        for (int next: graph.get(cur)) {
            if (dfs(graph, stMap, next)) return true;
        }
        stMap.put(cur, Status.VISITED);
        // 如果是拓扑加一行把cur加到res list中
        // for loop不执行完，cur不会加进res中
        return false;
    }
}
