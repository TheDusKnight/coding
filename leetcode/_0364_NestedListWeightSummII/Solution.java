package leetcode._0364_NestedListWeightSummII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int maxDepth = Integer.MIN_VALUE;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger nested: nestedList) {
            getMaxDepth(nested, 1); // dfs
            queue.offer(nested);
        }
        // bfs
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int curLevSum = 0;
            while (size-- > 0) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) {
                    curLevSum += cur.getInteger();
                } else {
                    for (NestedInteger next: cur.getList()) {
                        queue.offer(next);
                    }
                }
            }
            res += curLevSum * maxDepth--;
        }
        return res;
    }
    
    private void getMaxDepth(NestedInteger nested, int curDepth) {
        if (nested.isInteger()) {
            maxDepth = Math.max(maxDepth, curDepth);
            return;
        }
        
        for (NestedInteger next: nested.getList()) {
            getMaxDepth(next, curDepth+1);
        }
    }
}
// n为所有nestInteger的个数, 边的个数不会超过点(nestInteger)的个数
// time: dfs O(n+n) + bfs O(n+n) = O(n); space: stack O(log(n)) to O(n) + queue O(1) to O(n) = O(n)