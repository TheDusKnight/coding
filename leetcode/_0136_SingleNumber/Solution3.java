package leetcode._0136_SingleNumber;

// bit operation
class Solution3 {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}
