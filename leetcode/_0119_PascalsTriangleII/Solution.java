package leetcode._0119_PascalsTriangleII;
import java.util.*;

// dp自右向左填值，inplace操作
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) return res;
        
        res.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            res.add(1);
            for (int j = res.size()-2; j > 0; j--) {
                res.set(j, res.get(j-1) + res.get(j));
            }
        }
        
        return res;
    }
}
