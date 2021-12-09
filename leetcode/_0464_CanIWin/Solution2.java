package leetcode._0464_CanIWin;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    // dfs pruning
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0)
            return false;
        // 当desiredTotal为0时，直接宣布胜利
        if (desiredTotal <= 0)
            return true;
        // 必须检查所有可选数字加起来能否达到target，因为会有tie的情况
        int sum = (1+maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal)
            return false;
        // 将boolean[]使用比特操作保存起来
        int choosable = (1 << maxChoosableInteger) - 1;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        return dfs(desiredTotal, choosable, maxChoosableInteger, memo, 0);
    }
    
    private boolean dfs(int desiredTotal, int choosable, int maxChoosableInteger, Map<Integer, Boolean> memo, int curSum) {
        if (curSum >= desiredTotal)
            return false;
        Boolean val = memo.get(choosable);
        if (val != null)
            return val;
        
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << (i-1);
            // 尽量不要在for loop中check base case，时间复杂度高
            // if (curSum + i >= desiredTotal)
            //     return true;
            if ((choosable & mask) != 0) { // can choose
                if (!dfs(desiredTotal, choosable ^ mask, maxChoosableInteger, memo, curSum+i)) {
                    memo.put(choosable, true);
                    return true;
                }
            }
        }
        memo.put(choosable, false);
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canIWin(10, 11));
    }
}

// time: O(2^n * n) = O(2^n). n为maxChoosableInteger, 2^n是map存的所有可能的状态