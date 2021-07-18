package leetcode._0207_CourseSchedule;

import java.util.ArrayList;
import java.util.List;

// 拓扑因为course是连续的，改用array表示graph和statusMap
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // cc
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] statusMap = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, statusMap)) {
                return false;
            }
        }
        return true;
    }
    
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] tmp = new List[numCourses];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            tmp[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return tmp;
    }
    
    private boolean dfs(List<Integer>[] graph, int cur, int[] statusMap) {
        int status = statusMap[cur];
        if (status == 1) {
            return false;
        }
        if (status == 2) {
            return true;
        }
        
        statusMap[cur] = 1;
        List<Integer> nexts = graph[cur];
        if (nexts != null) {
            for (Integer next: nexts) {
                if (!dfs(graph, next, statusMap)) {
                    return false;
                }
            }
        }
        statusMap[cur] = 2;
        return true;
    }
}