package leetcode._0210_CourseScheduleII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 拓扑因为course是连续的，改用array表示graph和statusMap
// 和207类似，使用list记录拓扑排序
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // cc
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        int[] statusMap = new int[numCourses];
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, statusMap, out)) {
                return new int[0];
            }
        }
        // 记录拓扑的时候会先记录a，然后b，最后返回list先reverse
        Collections.reverse(out);
        int[] res = out.stream().mapToInt(i->i).toArray();
        return res;
    }
    
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] tmp = new List[numCourses];
        // 一种无脑初始化所有array里的ArrayList复杂度可能高
        // for (int i = 0; i < tmp.length; i++) {
        //     tmp[i] = new ArrayList<>();
        // }
        // 注意这里idx0代表pre，idx1代表cur，比如[a,b]，a依赖b所有b应该在a前面,b->a
        for (int i = 0; i < prerequisites.length; i++) {
            // 一种优化，只有当prerequisites存在对应index才初始化但需要在dfs check nexts是否为null
            if (tmp[prerequisites[i][1]] == null) {
                tmp[prerequisites[i][1]] = new ArrayList<>();
            }
            tmp[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        return tmp;
    }
    
    private boolean dfs(List<Integer>[] graph, int cur, int[] statusMap, List<Integer> out) {
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
                if (!dfs(graph, next, statusMap, out)) {
                    return false;
                }
            }
        }
        statusMap[cur] = 2;
        out.add(cur);
        return true;
    }
}
// numCourses = n, prerequisites length = k
// O(n+k+n*log(n))