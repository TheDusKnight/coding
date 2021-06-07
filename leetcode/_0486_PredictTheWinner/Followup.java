package leetcode._0486_PredictTheWinner;

public class Followup {
    public boolean PredictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        
        int len = nums.length;
        int[] dp = new int[len];
        int sum = 0;
        
        for (int i = len-1; i >= 0; i--) {
            sum += nums[i];
            int a = i+2 < len ? dp[i+2] : 0;
            int b = i+3 < len ? dp[i+3] : 0;
            int c = i+4 < len ? dp[i+4] : 0;
            dp[i] = Math.max(nums[i] + Math.min(a, b), nums[i] + (i+1 < len ? nums[i+1] : 0) + Math.min(b, c));
        }
        return dp[0] >= sum - dp[0];
    }

    public static void main(String[] args) {
        Followup sol = new Followup();
        System.out.println(sol.PredictTheWinner(new int[]{1,5,233,322}));
    }
}

// time: O(n)