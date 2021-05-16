package leetcode._0268_MissingNumber;

// math
class Solution5 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int expectedSum = (0+len) * (len+1) / 2;
        int sum = 0;
        
        for (int num : nums) {
            sum += num;
        }
        
        return expectedSum - sum;
    }
}
