package leetcode._0207_CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 拓扑查环
// hashmap实现，可优化
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // cc
        
        // 把input转换成graph
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        // 初始化statusMap
        Map<Integer, Integer> statusMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            statusMap.put(i, 0);
        }
        // 检查每一个graph node是否有环
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, statusMap)) { // 如果出环return false
                return false;
            }
        }
        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            // 注意这里idx0代表pre，idx1代表cur，比如[a,b]，a依赖b所以b应该在a前面,b->a，记录拓扑的时候会先记录a，然后b，最后返回list先reverse
            List<Integer> nexts = map.getOrDefault(prerequisites[i][1], new ArrayList<Integer>());
            nexts.add(prerequisites[i][0]);
            // 反向建图，也可以正向建图
            map.put(prerequisites[i][1], nexts);
        }
        return map;
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int cur, Map<Integer, Integer> statusMap) {
        int status = statusMap.get(cur);
        if (status == 1) { // ING
            return false;
        }
        if (status == 2) { // ED
            return true;
        }

        statusMap.put(cur, 1); // 将cur状态改成ING
        List<Integer> nexts = graph.get(cur);
        // 如果nexts不为null遍历nexts，如果为null，说明cur vertex是末端，不可能有环return true
        if (nexts != null) {
            for (Integer next : nexts) {
                if (!dfs(graph, next, statusMap)) {
                    return false;
                }
            }
        }
        
        statusMap.put(cur, 2);
        return true;
    }
}

// time: O(V+E) = O(n+k), n is number of numCourses, k is length of prerequisites
// 因为有pruning每个点和边摸常数次
