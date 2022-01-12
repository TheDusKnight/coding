package leetcode._0305_NumberOfIslandsII;

import java.util.ArrayList;
import java.util.List;

// UF
class Solution {
    private static final int[][] DIRECTIONS = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    class UnionFind {
        int[] parents, sizes;
        int row, col, numOfIsland;
        
        public UnionFind(int m, int n) {
            row = m; col = n;
            parents = new int[m*n];
            sizes = new int[m*n]; // this size of UF root;
            numOfIsland = 0;
            for (int i = 0; i < m*n; i++) parents[i] = -1;
        }
        
        private int getRoot(int p) { // p is 拉直of(i,j)
            int cur = p;
            while (parents[cur] != cur) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }
            parents[p] = cur;
            
            return cur;
        }
        
        private boolean find(int i1, int j1, int i2, int j2) {
            int p = i1*col+j1, q = i2*col+j2;
            return getRoot(p) == getRoot(q);
        }
        
        private void union(int i1, int j1, int i2, int j2) {
            int p = i1*col+j1, q = i2*col+j2;
            int rootP = getRoot(p), rootQ = getRoot(q);
            if (sizes[rootP] > sizes[rootQ]) {
                parents[rootQ] = rootP;
                sizes[rootP] += sizes[rootQ];
            } else {
                parents[rootP] = rootQ;
                sizes[rootQ] += sizes[rootP];
            }
            numOfIsland--;
        }
        
        public void addIsland(int i, int j) {
            int idx = i*col+j;
            if (parents[idx] == -1) { // 检查当前区域是否之前add过，和面试管沟通
                parents[idx] = idx; // 将该区域的root设为自己
                sizes[idx] = 1;
                numOfIsland++;
            }
        }
        
        public boolean isIsland(int i, int j) {
            return parents[i*col+j] >= 0;
        }
        
        public int getNumOfIsland() {
            return numOfIsland;
        }
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // cc
        
        UnionFind uf = new UnionFind(m, n);
        List<Integer> res = new ArrayList<>();
        for (int[] pos: positions) {
            int i = pos[0], j = pos[1];
            uf.addIsland(i, j);
            for (int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n)
                    continue;
                if (uf.isIsland(ii, jj) && !uf.find(i, j, ii, jj))
                    uf.union(i, j, ii, jj);
            }
            res.add(uf.getNumOfIsland());
        }
        
        return res;
    }
}

// time:
// brute force bfs/dfs: O(m*n*k) k是新的island的个数
// 优化: O(4*k*log(m*n)) = O(k*log(mn)) 因为UF操作都是log(m*N)，一共做k次