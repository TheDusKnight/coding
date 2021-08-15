package leetcode._0207_CourseSchedule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution3 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] mark = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, mark, i))
                return false;
        }
        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, ele -> new ArrayList<>());

        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> nexts = graph[prerequisites[i][1]];
            nexts.add(prerequisites[i][0]);
            graph[prerequisites[i][1]] = nexts;
        }

        return graph;
    }

    private boolean dfs(List<Integer>[] graph, int[] mark, int cur) {
        int status = mark[cur];
        if (status == 1) return false;
        if (status == 2) return true;

        mark[cur] = 1;
        List<Integer> nexts = graph[cur];

        if (nexts != null) {
            for (int next: nexts) {
                if (!dfs(graph, mark, next))
                    return false;
            }
        }
        
        mark[cur] = 2;
        return true;
    }
}
