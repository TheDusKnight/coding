package leetcode._0785_IsGraphBipartite;
import java.util.*;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        int notColored = -1;
        Arrays.fill(color, notColored);
        
        for (int i = 0; i < len; i++) {
            // 找没有被color过的node作为新的root
            if (color[i] == notColored) {
                color[i] = 0;
                
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int neighbor : graph[cur]) {
                        if (color[neighbor] != notColored) {
                            if (color[cur] == color[neighbor]) return false;
                        }
                        else {
                            color[neighbor] = 1 - color[cur];
                            // 类似tree找子结点并验证是否符合bipartite性质
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }
}

// time O(N + E)
// space: O(N), the space used to store the color