package leetcode;

// dp练习
public class LongestAscendingSubarray {
    public static int longest(int[] array) {
        int[] dp = new int[array.length];
        // Arrays.fill(dp, 1);
        // System.out.println(Arrays.toString(dp));
        dp[0] = 1;
        int max = dp[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i-1] < array[i]) {
                dp[i] = dp[i-1] + 1;
            } else dp[i] = 1;

            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int longest2(int[] array) {
        int cur = 1;
        int max = cur;

        for (int i = 1; i < array.length; i++) {
            if (array[i-1] < array[i]) {
                cur = cur + 1;
            } else {
                cur = 1;
            }
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {5,2,4,1,8,9,10,7};
        int res = longest(array);
        System.out.println(res);
        int res2 = longest2(array);
        System.out.println(res2);
    }
}
