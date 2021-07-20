package leetcode._0200_NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

// bfs
public class Solution2 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length, col = grid[0].length, count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 每见到island就开始一次bfs
                if (grid[i][j] == '1') {
                    count++;
                    grid[i][j] = '0'; // mark as visited
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.offer(i*col+j);
                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        int ii = cur / col, jj = cur % col;
                        // 上下左右找island并将其变为海水
                        if (ii-1 >= 0 && grid[ii-1][jj] == '1') { // 如果邻居是island
                            queue.offer((ii-1)*col+jj); // 把邻居加入queue，check邻居的邻居
                            grid[ii-1][jj] = '0'; // 把邻居变成海
                        }
                        if (ii+1 < row && grid[ii+1][jj] == '1') {
                            queue.offer((ii+1)*col+jj);
                            grid[ii+1][jj] = '0';
                        }
                        if (jj-1 >= 0 && grid[ii][jj-1] == '1') {
                            queue.offer(ii*col+jj-1);
                            grid[ii][jj-1] = '0';
                        }
                        if (jj+1 < col && grid[ii][jj+1] == '1') {
                            queue.offer(ii*col+jj+1);
                            grid[ii][jj+1] ='0';
                        }
                    }
                }
            }
        }
        return count;
    }
}

// time: O(mn)，长治久安，一次bfs mark完所有visited的话，接下来所有bfs都是O(1); space: O(min(m,n))。因为bfs在2d matrix扫的时候一层最多有min(m,n)个island，也就是对角线

