package leetcode._0300_LongestIncreasingSubsequence;
import java.util.*;

// recursion with memo
public class Solution2 {
    int memo[][];

    public int lengthOfLIS(int[] nums) { 
        memo = new int[nums.length + 1][nums.length];
        for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
        // return 1;
        return lengthofLIS(nums, -1, 0);
    }
    
    public int lengthofLIS(int[] nums, int previndex, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        if (memo[previndex + 1][curpos] >= 0) {
            return memo[previndex + 1][curpos];
        }
        int taken = 0;
        if (previndex < 0 || nums[curpos] > nums[previndex]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1);
        }

        int nottaken = lengthofLIS(nums, previndex, curpos + 1);
        memo[previndex + 1][curpos] = Math.max(taken, nottaken);
        return memo[previndex + 1][curpos];
    }
}