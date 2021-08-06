package leetcode._0403_FrogJump;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // dfs + pruning
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1)
            return false;
        if (stones[1] - stones[0] != 1) // 必须加否则跑不过去
            return false;

        Map<Integer, Boolean>[] memo = new HashMap[stones.length];
        for (int i = 0; i < stones.length; i++) {
            memo[i] = new HashMap<Integer, Boolean>();
        }
        return search(stones, 1, 1, memo);
    }

    private boolean search(int[] stones, int idx, int k, Map<Integer, Boolean>[] memo) {
        int len = stones.length;
        // 注意题意，landing on the last stone直接返回true，而不是香有些问题last index依然要做事情
        if (idx == len - 1)
            return true;

        Map<Integer, Boolean> map = memo[idx];
        Boolean m = map.get(k);
        if (m != null)
            return m;

        for (int i = idx + 1; i < len; i++) {
            int dis = stones[i] - stones[idx];
            // 间隔过大终止
            if (dis > k + 1)
                break;
            // 只要间隔valid，进入下一层dfs check
            if (dis == k - 1 || dis == k || dis == k + 1) {
                if (search(stones, i, dis, memo)) {
                    map.put(k, true);
                    return true;
                }
            }
        }
        map.put(k, false);
        return false;
    }
}

// time: O(n^2 * n) = O(n^3). memo size O(n^2)因为内部map最大长度为 * for loop O(n); 