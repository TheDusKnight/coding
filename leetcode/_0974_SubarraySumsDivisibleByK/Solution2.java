package leetcode._0974_SubarraySumsDivisibleByK;

// prefix sum 存取模的结果 + array
class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        // cc
        int[] map = new int[k];
        map[0] = 1;
        int sum = 0, count = 0;
        
        for (int a: nums) {
            sum = (sum + a) % k;
            if (sum < 0)
                sum += k;
            count += map[sum];
            map[sum] += 1;
        }
        return count;
    }
}

// time: O(n); space: O(k);