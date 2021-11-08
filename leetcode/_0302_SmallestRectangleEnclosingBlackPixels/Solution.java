package leetcode._0302_SmallestRectangleEnclosingBlackPixels;

// binary search, 找上下左右边界
class Solution {
    int m, n;
    public int minArea(char[][] image, int x, int y) {
        // cc
        
        m = image.length; n = image[0].length;
        
        int start = 0, end = y;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isWhiteCol(image, mid)) start = mid+1;
            else end = mid-1;
        }
        int lBound = start;
        
        start = y; end = n-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isWhiteCol(image, mid)) end = mid-1;
            else start = mid+1;
        }
        
        int rBound = end;
        
        start = 0; end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isWhiteRow(image, mid)) start = mid+1;
            else end = mid-1;
        }
        
        int tBound = start;
        
        start = x; end = m-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isWhiteRow(image, mid)) end = mid-1;
            else start = mid+1;
        }
        
        int bBound = end;
        
        return (rBound-lBound+1) * (bBound-tBound+1);
    }
    
    private boolean isWhiteCol(char[][] image, int col) {
        for (int i = 0; i < m; i++) {
            if (image[i][col] != '0') return false;
        }
        
        return true;
    }
    
    private boolean isWhiteRow(char[][] image, int row) {
        for (int i = 0; i < n; i++) {
            if (image[row][i] != '0') return false;
        }
        
        return true;
    }
}

// time: O(log(n)*m + log(m)*n); space: O(1);