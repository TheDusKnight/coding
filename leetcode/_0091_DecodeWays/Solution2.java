package leetcode._0091_DecodeWays;

// dp best solution
class Solution2 {

    public int numDecodings(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length()+1];
        dp[0] = 1; // 这个1是自带的
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i < dp.length; i++) {
            // 填最后一个值是i-1正好是最后一个s的值
            if (s.charAt(i-1) != '0')
                dp[i] += dp[i-1];
            
            // Integer.valueOf vs Integer.parseInt
            int twoDigit = Integer.parseInt(s.substring(i-2, i));
            if (twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i-2];
        }
        
        return dp[dp.length-1];

    }
}
// time: O(n)
// space: O(n)