package leetcode._0547_NumberOfProvinces;

class Solution {
    int row, col;

    public int findCircleNum(int[][] isConnected) {
        // cc
        row = isConnected.length;
        col = isConnected[0].length;
        boolean[] visited = new boolean[row];
        int count = 0;

        for (int i = 0; i < row; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        for (int j = 0; j < col; j++) {
            // 如果两个点是directly connect并且和i比较的j没有visited过
            // 注意i和j可以是同一个点，也就是说即使一个点只和自己connect也可以使count++
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, j);
            }
        }
    }
}

// time: O(n^2). touch every node at most twice, node number is n^2; space: O(n
// ~ n^2)
