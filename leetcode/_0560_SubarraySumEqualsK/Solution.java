package leetcode._0560_SubarraySumEqualsK;

// 如果Integer All Positive，sliding window版本
// 无法用于有负数的情况因为右指针往右走有可能越走越小
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return -1;

        int count = 0;
        int l = 0, r = 0;
        int len = nums.length;
        int sum = nums[0];
        while (l <= r) {
            if (sum == k) { // 每找到一次k，就加一
                count++;
            }
            if (sum <= k) { // 等于判断可以放在小于也可以大于condition
                if (++r >= len)
                    break; // 防越界
                sum += nums[r];
            } else {
                sum -= nums[l];
                if (++l >= len)
                    break; // 防越界
            }
        }
        return count;
    }
}

// time: O(n); space: O(1)