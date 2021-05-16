package leetcode._0118_PascalsTriangle;
import java.util.*;

// dp自右向左填值
class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>(res.get(i-1));
            
            curRow.add(1);
            for (int j = curRow.size()-2; j > 0; j--) {
                curRow.set(j, curRow.get(j) + curRow.get(j-1));
            }
            res.add(curRow);
        }
        return res;
    }
}