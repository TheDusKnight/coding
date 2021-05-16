package leetcode._0343_IntegerBreak;

// 切绳子
// dp 对应recursion binary reduction, 再切一刀切在哪儿，答案出在每个node
// 还有一种recursion linear reduction，每个位置切或不切，答案出在leaf node
class Solution {
    public int integerBreak(int n) {
        if (n < 2) throw new IllegalArgumentException();

        int[] dp = new int[n+1];
        dp[1] = 0;

        // i是几就对应绳子的长度为几
        for (int i = 1; i <= n; i++) {
            int curMax = 0;
            int curVal;
            // j只需要到绳子长度的一半因为另一半重复
            for (int j = 1; j <= i/2; j++) {
                // 切左半的最大值乘右半的最大值为当前切的位置的最大值
                curVal = Math.max(j, dp[j]) * Math.max(i-j, dp[i-j]);
                // 所有位置切一遍，更新全局最大值
                curMax = Math.max(curMax, curVal);
            }
            // 长度为i时的最大乘积
            dp[i] = curMax;
        }

        return dp[n];
    }
}

// time: O(n^2)
// dp数学优化：通过判断i是否大于4并使切的位置尽量靠中间