package jianzhioffer.array._11;

/**
 * 旋转数组中的最小数字 same as lc154
 */

// Brute force linear search
public class Solution {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i-1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
}

// time: O(n); space: O(1);