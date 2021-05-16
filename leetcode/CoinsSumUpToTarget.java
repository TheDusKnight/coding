package leetcode;
import java.util.*;

public class CoinsSumUpToTarget {
    public List<int[]> change(int[] coins, int amount) {
        int[] sol = new int[coins.length];
        List<int[]> res = new ArrayList<>();
        dfs(coins, 0, amount, sol, res);
        return res;
    }
    
    private void dfs(int[] coins, int level, int left_balance, int[] sol, List<int[]> res) {
        // base case
        if (level == coins.length-1) {
            sol[level] = left_balance;
            res.add(sol.clone());
            return;
        }
        int num = left_balance / coins[level] + 1;
        for (int i = 0; i < num; i++) {
            sol[level] = i;
            dfs(coins, level + 1, left_balance - i * coins[level], sol, res);
        }
    }
}
