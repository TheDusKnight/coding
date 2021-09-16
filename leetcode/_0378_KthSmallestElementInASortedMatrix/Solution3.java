package leetcode._0378_KthSmallestElementInASortedMatrix;

// binary search in matrix
class Solution3 {
    int[][] matrix;
    int k;
    int n;
    public int kthSmallest(int[][] matrix, int k) {
        // cc
        
        this.matrix = matrix;
        this.k = k;
        this.n = matrix.length;
        
        int start = matrix[0][0], end = matrix[n-1][n-1];
        int res = search(start, end);
                
        return res;
    }
    
    private int search(int start, int end) {
        if (start == end) return end; // 当left side有重复会出现lCount != k
        
        int mid = start + (end - start) / 2;
        int lCount = 0;
        int lMax = Integer.MIN_VALUE, rMin = Integer.MAX_VALUE;
        
        // 找小数 brute force
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] <= mid) {
        //             lCount++;
        //             lMax = Math.max(lMax, matrix[i][j]);
        //         } else {
        //             rMin = Math.min(rMin, matrix[i][j]);
        //         }
        //     }
        // }
        
        int row = n - 1, col = 0;
        // time: O(N + N) = O(N);
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                lMax = Math.max(lMax, matrix[row][col]);
                lCount += row + 1; // 包括当前row在内的上方rows全部小于等于mid (row从小到大sort)
                col++;
            } else {
                rMin = Math.min(rMin, matrix[row][col]);
                row--;
            }
        }
        
        if (lCount == k) {
            return lMax;
        } else if (lCount < k) {
            return search(rMin, end);
        } else {
            return search(start, lMax);
        }
    }
}

// time: O(log(MAX - MIN) * N); MAX is the max element, MIN is the min element. N is the matrix square length; space: O(1);