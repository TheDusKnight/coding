package leetcode._0268_MissingNumber;

// bit operation
public class Solution6 {
    public int missingNumber(int[] nums) {
        int target = nums.length;
        for (int i = 0; i < nums.length; i++) {
            target ^= i ^ nums[i];
        }
        return target;
    }
}
