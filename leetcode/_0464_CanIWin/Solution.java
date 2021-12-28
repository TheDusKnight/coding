package leetcode._0464_CanIWin;

import java.util.Arrays;

class Solution {
    // dfs no pruning time limit exceeded
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0)
            return false;
        if (desiredTotal <= 0) // 当desiredTotal为0时，直接宣布胜利
            return true;
        boolean[] choosable = new boolean[maxChoosableInteger+1];
        Arrays.fill(choosable, true); // 忘记初始化了
        return dfs(desiredTotal, 0, choosable);
    }
    
    private boolean dfs(int desiredTotal, int max, boolean[] choosable) {
        if (max >= desiredTotal)
            return false;
        
        for (int i = 1; i < choosable.length; i++) {
            if (choosable[i]) {
                choosable[i] = false;
                // 必须先记录res否则无法还原visited
                boolean res = dfs(desiredTotal, max+i, choosable);
                choosable[i] = true;
                // 不通才通
                if (!res)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canIWin(10, 11));
    }
}

// time: O(n^n)
