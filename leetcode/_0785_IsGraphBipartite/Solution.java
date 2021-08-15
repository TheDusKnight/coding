package leetcode._0785_IsGraphBipartite;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 图的遍历bfs写法
class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] color = new int[len];
        int notColored = -1;
        Arrays.fill(color, notColored); // 把每个点标记成-1
        
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
                            // 两个相邻的node颜色一样，return false
                            if (color[cur] == color[neighbor]) return false;
                        }
                        else {
                            color[neighbor] = 1 - color[cur]; // 将neighbor标记成不同颜色
                            // 通过neighbor继续找neighbor直到找不到为止
                            // 但for loop还是要继续因为题目说了The graph may not be connected，所以while loop有可能没遍历完所有点
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
        return true;
    }
}

// time O(N + E), N is number of nodes, E is number of edge
// space: O(N), the space used to store the color and queue max size is also O(N)