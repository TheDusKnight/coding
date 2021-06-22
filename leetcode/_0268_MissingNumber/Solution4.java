package leetcode._0268_MissingNumber;

public class Solution4 {
    // math
    public int missingNumber(int[] nums) {
        // [3,0,1], expectedSum: [0,1,2,3]=6, sum: [0,1,3]=4
        int expectedSum = (nums.length+1)*(0+nums.length)/2;
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        return expectedSum - sum;
    }
}
// time: O(n); space: O(1);
