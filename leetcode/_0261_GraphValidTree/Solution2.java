package leetcode._0261_GraphValidTree;

// UF常规题
class Solution2 {
    class UnionFind {
        int size;
        int[] parents, sizes;
        
        public UnionFind(int n) {
            this.size = n; // UF有多少区域，非必要可以不记录
            this.parents = new int[n];
            this.sizes = new int[n];
            
            for (int i = 0; i < n; i++) {
                parents[i] = i; // 将每个区域的root设为自己
                sizes[i] = 1; // 将每个区域的root的size设为1
            }
        }
        
        public boolean find(int p, int q) {
            return getRoot(p) == getRoot(q);
        }
        
        public void union(int p, int q) {
            int rootP = getRoot(p), rootQ = getRoot(q);
            if (sizes[rootP] > sizes[rootQ]) {
                parents[rootQ] = rootP;
                sizes[rootP] += sizes[rootQ];
            } else {
                parents[rootP] = rootQ;
                sizes[rootQ] += sizes[rootP];
            }
            parents[rootP] = rootQ;
            sizes[rootQ] += sizes[rootP];
            size--;
        }
        
        public int getRoot(int i) {
            int cur = i;
            while (parents[cur] != cur) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }
            parents[i] = cur;
            return cur;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        // cc
        if (n != edges.length + 1)
            return false;
        
        UnionFind uf = new UnionFind(n);
        for (int[] e: edges) { // O(n)
            int p = e[0], q = e[1];
            // 如果union之前发现在同一村子说明出环了
            if (uf.find(p, q)) { 
                return false; // O(logn)
            } else {
                uf.union(p, q); // O(1)
            }
        }
        return true;
    }
}

// time: O(n*logn)
