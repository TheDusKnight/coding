package jianzhioffer.array._03;
import java.util.Arrays;

/**
 * 数组中重复的数字
 */

// sort then find duplicate
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        throw new IllegalArgumentException("Invalid");
    }

    public static void main(String[] args) {
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        Solution solution = new Solution();
        int res = solution.findRepeatNumber(arr);
        System.out.println(res);
    }
}

// time: n*log(n); space: 1
