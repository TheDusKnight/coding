package leetcode._0118_PascalsTriangle;
import java.util.*;

// dp自左向右填值
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        
        // first row is always [1]
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = res.get(i-1);
            
            // first element is always 1
            row.add(1);
            // 对着prevRow从左到右填值
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            // last element is always 1
            row.add(1);
            
            res.add(row);
        }
        return res;
    }
}
