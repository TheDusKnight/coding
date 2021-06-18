package leetcode._0167_TwoSumIIInputArrayIsSorted;

public class Solution {
    // two pointers left right
    public int[] twoSum(int[] numbers, int target) {
        // cc
        
        int l = 0, r = numbers.length-1;
        while (l + 1 < r) { // 相邻
            int curSum = numbers[l] + numbers[r];
            if (curSum == target) {
                break;
            } else if (curSum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{l+1, r+1};
    }
}

// time: O(n)