package leetcode._0200_NumberOfIslands;

// UF，这是标准答案但和算法哥写法不一样
public class Solution3 {
    private class UnionFind {
        public int size, row, col;
        public int[] ids, sz;

        public UnionFind(int row, int col) {
            this.size = 0;
            this.row = row;
            this.col = col;
            int len = row * col;
            ids = new int[len];
            sz = new int[len];
            // 初始化每个区域的代表root以及root的size
            for (int i = 0; i < len; i++) {
                ids[i] = -1; // 一开始不知道是不是island所以先初始化成-1，等addIsland时再改
                sz[i] = 1; // the size of root
            }
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int rootP = root(p), rootQ = root(q);
            if (sz[rootP] > sz[rootQ]) {
                ids[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
                this.size--; // 把两个岛屿union成一个，size-1
            } else {
                ids[rootP] = rootQ;
                sz[rootQ] += sz[rootP];
                this.size--;
            }
        }

        private int root(int p) { // 找到当前p的root
            int tempP = p;
            while(ids[p] != p) { // 当p的代表不是自己时
                ids[p] = ids[ids[p]]; // 认爷做父
                p = ids[p]; // p往前前进一格
            }
            ids[tempP] = p; // p现在是原始p的代表
            return p;
        }

        public int index(int i, int j) {
            return i*col+j;
        }

        public void addIsland(int p) {
            if (ids[p] == -1) {
                ids[p] = p; // add是把代表初始化成自己
                size++;
            }
        }

        public boolean isIsland(int p) {
            return ids[p] != -1;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null) {
            return 0;
        }

        int row = grid.length, col = grid[0].length;
        UnionFind uf = new UnionFind(row, col);

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') { // 如果当前区域是岛屿
                    int p = uf.index(i, j);
                    // 把岛屿加入UF
                    uf.addIsland(p);
                    // 判断四周有没有island需要union
                    for (int[] dir: directions) {
                        int rowIdx = i + dir[0], colIdx = j + dir[1];
                        int q = uf.index(rowIdx, colIdx);
                        if (rowIdx >= 0 && rowIdx < row && colIdx >= 0 && colIdx < col && uf.isIsland(q) && !uf.find(p, q)) {
                            uf.union(p, q);
                        }
                    }
                }
            }
        }
        return uf.size;
    }
}

// time: O(mn*log(mn));
