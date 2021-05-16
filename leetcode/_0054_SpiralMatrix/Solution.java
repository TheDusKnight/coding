package leetcode._0054_SpiralMatrix;
import java.util.*;

// recursion
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        int length = matrix[0].length;
        int height = matrix.length;
        spiral(matrix, 0, length, height, res);
        return res;
    }
    
    private void spiral(int[][] matrix, int offset, int length, int height, List<Integer> res) {
        if (length == 0 || height == 0) return;
        if (length == 1) {
            for (int i = 0; i < height; i++) res.add(matrix[offset+i][offset]);
            return;
        }
        if (height == 1) {
            for (int i = 0; i < length; i++) res.add(matrix[offset][offset+i]);
            return;
        }
        
        for (int i = 0; i < length-1; i++) {
            res.add(matrix[offset][offset+i]);
        }
        for (int i = 0; i < height-1; i++) {
            res.add(matrix[offset+i][offset+length-1]);
        }
        for (int i = 0; i < length-1; i++) {
            res.add(matrix[offset+height-1][offset+length-1-i]);
        }
        for (int i = 0; i < height-1; i++) {
            res.add(matrix[offset+height-1-i][offset]);
        }
        spiral(matrix, offset+1, length-2, height-2, res);
    }
}