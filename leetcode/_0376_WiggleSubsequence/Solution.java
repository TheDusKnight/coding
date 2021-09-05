package leetcode._0376_WiggleSubsequence;

// Tesla OA
// https://leetcode.com/problems/wiggle-subsequence/discuss/85014/java-on-solution-you-only-need-to-count-the-peak-and-valley
class Solution {
    public static int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        int count = 1;
        int i = 0, j = i + 1;
        while(i < nums.length && j < nums.length){
            if(nums[j] == nums[i]){
                ++i;
                ++j;
            }else if(nums[j] > nums[i]){
                ++count;
                int k = j + 1;
                while(k < nums.length && nums[k] >= nums[k - 1]){
                    ++k;
                }
                if(k == nums.length)
                    return count;
                i = k - 1;
                j = k;
            }else{
                ++count;
                int k = j + 1;
                while(k < nums.length && nums[k] <= nums[k - 1]){
                    ++k;
                }
                if(k == nums.length)
                    return count;
                i = k - 1;
                j = k;
            }
        }
        return count;
    }
}
