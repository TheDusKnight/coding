package amazon.TotalWays;

// array two pass
public class Solution {
    public int totalWays(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0, rightSum = 0, count = 0;
        for (int i = 0; i < nums.length - 1; i++) { // 题目要求左右不能为空
            leftSum += nums[i]; rightSum = sum - leftSum;
            if (leftSum > rightSum)
                count++;
        }
        return count;
    }
}
