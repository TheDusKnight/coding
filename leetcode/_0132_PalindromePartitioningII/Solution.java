package leetcode._0132_PalindromePartitioningII;

class Solution {
    // dp超时
    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return -1;
        
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 0;
        
        for (int i = len-1; i >= 0; i--) {
            dp[i] = len-1-i+1; // i,j闭闭区间最多几个substring
            for (int j = i; j < len; j++) {
                String sub = s.substring(i,j+1);
                if (isPalindrome(sub)) {
                    dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }
        return dp[0]-1;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            // while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            // while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }
}

// time: O(n^3)