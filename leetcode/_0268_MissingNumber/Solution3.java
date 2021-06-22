package leetcode._0268_MissingNumber;

public class Solution3 {
    // bit
    public int missingNumber(int[] nums) {
        // cc
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            // 相同的i和nums[i] cancel，不同的留下来和nums.lenggth,最后match不上的留下来
            res ^= i ^ nums[i];
        }
        return res;
    }
}

// time: O(n); space: O(1)
