package leetcode._0132_PalindromePartitioningII;

class Solution2 {
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return -1;
        
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 0;
        // 使用boolean array缩短check palindrome时间
        boolean[][] checkP = new boolean[len][len];
        
        for (int i = len-1; i >= 0; i--) {
            dp[i] = len-1-i+1; // i,j闭闭区间最多几个substring
            for (int j = i; j < len; j++) {
                if (i == j // len is 1
                    || (s.charAt(i) == s.charAt(j) && (i+1==j // len is 2
                    || checkP[i+1][j-1]))) { // len is 3 or more
                    checkP[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }
        return dp[0]-1;
    }
}

// time: O(n^2)
