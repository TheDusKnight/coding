package leetcode._0120_Triangle;
import java.util.*;

// dp空间优化 -> 进一步优化成inplace
public class Solution5 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len-1).get(i);
        }

        for (int i = len-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}

// time: O(n^2)
// space: O(n)