package leetcode._0286_WallsAndGates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// bfs 搜图的最短路径
class Solution {
    private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void addAllZeros(int[][] rooms, Queue<Integer> queue) {
        // 问面试管是否存在出界的情况?
        int colLen = rooms[0].length;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * colLen + j);
                }
            }
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            throw new IllegalArgumentException();
            // return;
        }

        int col = rooms[0].length, row = rooms.length;
        Queue<Integer> queue = new LinkedList<>();
        addAllZeros(rooms, queue);
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                int i = cur / col;
                int j = cur % col;
                for (int[] dir : DIRECTIONS) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && rooms[ii][jj] == Integer.MAX_VALUE) {
                        queue.offer(ii * col + jj);
                        rooms[ii][jj] = minLen;
                    }
                }
            }
            minLen++;
        }
    }

    public static void main(String[] args) {
        // int[][] test = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
        //         { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
        int[][] test = {};
        Solution solution = new Solution();
        solution.wallsAndGates(test);
        for (int[] cur : test) {
            System.out.println(Arrays.toString(cur));
        }
    }
}