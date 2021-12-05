package leetcode._0167_TwoSumIIInputArrayIsSorted;

// two pointers left right
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // cc
        
        int len = numbers.length, start = 0, end = len-1;
        while (start < end) {
            int val = numbers[start]+numbers[end];
            if (val == target) return new int[] {start+1, end+1};
            else if (val < target) start++;
            else end--;
        }
        
        throw new RuntimeException("res not found");
    }
}

// time: O(n); space: O(1);