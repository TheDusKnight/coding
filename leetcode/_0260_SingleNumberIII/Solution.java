package leetcode._0260_SingleNumberIII;

// bit使用mask找出两个不同数某个不同bit的位置，再根据位置将所有数分成两组使用Single Number I
class Solution {
    public int[] singleNumber(int[] nums) {
        // cc
        
        int xor = 0, n = nums.length;
        for (int num: nums) {
            xor ^= num;
        }
        
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        
        int num1 = 0, num2 = 0;
        for (int num: nums) {
            if ((num & mask) == 0) num1 ^= num;
            else num2 ^= num;
        }
        
        return new int[] {num1, num2};
    }
}

// time: O(N); space: O(1);
