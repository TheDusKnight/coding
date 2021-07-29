package leetcode._0200_NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

// bfs, 非常标准的2d matrix bfs问题
public class Solution2 {
    private static final int[][] DIRECTIONS = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        
        int row = grid.length, col = grid[0].length, count = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == '1') {
                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(r * col + c);
                    grid[r][c] = '0';
                    count++;
                    // 上下左右找island并将其变为海水
                    // bfs不是查环而是确保visit过的点不会revisit，把visit过的点设为0可以保证不会再次visit
                    while(!queue.isEmpty()) {
                        int cur = queue.poll();
                        int i = cur / col;
                        int j = cur % col;
                        for (int[] dir: DIRECTIONS) {
                            int ii = i + dir[0];
                            int jj = j + dir[1];
                            if (ii >= 0 && ii < row && jj >= 0 && jj < col && grid[ii][jj] == '1') {
                                queue.offer(ii * col + jj);
                                grid[ii][jj] = '0'; // 把看到的1变成0
                            }
                        }
                    } 
                }
            }
        }
        return count;
    }
}

// time: O(mn)，长治久安，一次bfs mark完所有visited的话，接下来所有bfs都是O(1); space: O(min(m,n))。因为bfs在2d matrix扫的时候一层最多有min(m,n)个island，也就是对角线

